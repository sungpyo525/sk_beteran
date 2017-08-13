package com.spring.beteran.suggest.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.spring.beteran.suggest.model.vo.PredictedRateVO;



public class RecommendFromHashMap {
	
	
	// *******************************영화 둘 간의 공통 유저를 list로 뽑는다.************************************
	public ArrayList<String> getSimUserList(int item, int anotherItem, HashMap<Integer, HashMap<String, Double>> data) {
		
		ArrayList<String> sameMovie = new ArrayList<>(); // 비교 대상과 공통으로 평가한 영화이름 리스트
		Iterator<String> iter = data.get(item).keySet().iterator();
		// 나에 대한 영화 키값을 set으로 반환 iterator변환
		while (iter.hasNext()) {
			String iterItem = iter.next();// item에 대해 반복 돌리면서

			Iterator<String> iter2 = data.get(anotherItem).keySet().iterator(); // 한번돌릴때마다 anotherItem초기화
			while (iter2.hasNext()) {// another 반복 돌리면서
				String iterAnother = iter2.next();
				if (iterItem.equals(iterAnother)) { // 나와 another가 같다면
					//System.out.println( item + "와" + anotherItem+" 같다. : ");
					sameMovie.add(iterItem);
					break; // 키값은 공통된 것이 없으므로 바로 break
				}
			}
		}
		return sameMovie;
	}
	
	// *******************************영화 둘 간의 유사도를 구한다************************************
	public double getUdistance(int item, int anotherItem, HashMap<Integer, HashMap<String, Double>> data) {

		double sum = 0.0;
		double minus = 0.0;
		double finalvalue = 0.0; // 유사도 값
		try {
			Iterator<String> iter = getSimUserList(item, anotherItem, data).iterator();

			while (iter.hasNext()) {
				String sameItem = iter.next();
				try {
					minus = data.get(item).get(sameItem) - data.get(anotherItem).get(sameItem);
					// i 영화코드에 대해서 (나의 평점, 비교대상의 영화평점 차)를 구한다
				} catch (NullPointerException e) {
				}

				double pow = Math.pow(minus, 2); // 위에서 구한 값을 제곱하고
				sum += pow; // 누적합을 구한다.
			}
			finalvalue = 1 / (1 + Math.sqrt(sum)); // 최종 유사도 계산
			
		} catch (Exception e) {
		}

		return finalvalue;
	}
	// ***********************************************************************************************
	
	
	//****************한 영화를 다른 모든 영화들과 유사도 비교 버전1, 사용안함(top 몇개를 뽑을지 설정할 수 있다.) ***************************
/*		public TreeMap<Integer,Double> topMatches(int item, int n){
			
			Iterator<Integer> iterOuterCode = data.keySet().iterator(); //데이터에서 키셋뽑아서 이터레이터
					
			HashMap<Integer, Double> map = new HashMap<>();
			ValueComparator bvc = new ValueComparator( map );
			TreeMap<Integer,Double> sorted_map = new TreeMap<Integer ,Double>(bvc);
			TreeMap<Integer,Double> resultMap = new TreeMap<Integer ,Double>(bvc);
			
			int count=0;
			
			System.out.print("전체 유사도 계산 중 .....");
			while(iterOuterCode.hasNext()) //이터레이터만큼 루프
			{
				int OuterCode = iterOuterCode.next();
				if((OuterCode)!=item){ //나와 코드가 다르다면 유사도를 계산하고 simList에 값을 추가
	        		map.put( OuterCode, getUdistance(item,OuterCode) );
				}	
	        }
			System.out.println("	완료");
			sorted_map.putAll(map);
			
			//유사도가 큰순서대로 뽑기
			for(Integer key :sorted_map.keySet()){
				
				resultMap.put(key,map.get(key));
				count++;
				
				if(count==n){
					break;
				}
			}
			System.out.println("	상위"+n+"개 뽑아내기 완료");
			
			System.out.println("--------------------------------------");

			
			return resultMap;
		}*/
	
	//****************한 영화를 다른 모든 영화들과 유사도 비교 버전2 ( 무조건 영화 전체 비교 계산)***************************
		public HashMap<Integer, Double> topMatches(int item, HashMap<Integer, HashMap<String, Double>> data){
			
			Iterator<Integer> iterOuterCode = data.keySet().iterator(); //데이터에서 키셋뽑아서 이터레이터
					
			HashMap<Integer, Double> map = new HashMap<>();
			//ValueComparator bvc = new ValueComparator( map );
			//TreeMap<Integer,Double> sorted_map = new TreeMap<Integer ,Double>(bvc);
			//TreeMap<Integer,Double> resultMap = new TreeMap<Integer ,Double>(bvc);
			
			int count=0;
			
			System.out.print("전체 유사도 계산 중 .....");
			while(iterOuterCode.hasNext()) //이터레이터만큼 루프
			{
				int OuterCode = iterOuterCode.next();
				if((OuterCode)!=item){ //나와 코드가 다르다면 유사도를 계산하고 simList에 값을 추가
	        		map.put( OuterCode, getUdistance(item,OuterCode,data) );
				}	
	        }
			System.out.println("	완료");
			//sorted_map.putAll(map);
			
			//유사도가 큰순서대로 뽑기
		/*	for(Integer key :sorted_map.keySet()){
				
				resultMap.put(key,map.get(key));
				count++;
				
				if(count==n){
					break;
				}
			}*/
			//System.out.println("	상위"+n+"개 뽑아내기 완료");
			
			System.out.println("--------------------------------------");

			
			return map;
		}
		
		//****************************************모든 영화에 대해 유사도 데이터 생성(topMaches)******************************************
		public HashMap<Integer, HashMap<Integer,Double>> similarItems(HashMap<Integer, HashMap<String, Double>> data) throws IOException{
			
			//BufferedWriter bw = new BufferedWriter(new FileWriter("similarItems2.txt"));
			
			HashMap<Integer, HashMap<Integer,Double>> outer=new HashMap<>();
			int percent=0;
			
			Iterator<Integer> iterOuterCode = data.keySet().iterator();
			while(iterOuterCode.hasNext()){ //전체 스캔
				
				int OuterCode = iterOuterCode.next();
				
				System.out.println("iter확인, 계산시작");
				outer.put(OuterCode, this.topMatches(OuterCode, data));
				//bw.write(OuterCode + "|" + this.topMatches(OuterCode, n) + "\n"); // txt로 저장
				System.out.println("저장완료");
				System.out.println(++percent+"/"+data.size());
			}
			//bw.close();
			return outer;
		}
		
		//*********************************************user에게 영화 추천***********************************************
		public ArrayList<PredictedRateVO> recommendMovie
				(String user,
				HashMap<String, HashMap<Integer, Double>> userData,
				HashMap<Integer, HashMap<Integer, Double>> data
				) throws Exception{   
				//recommendMovie(유저, 베스트몇개, userData)
			//HashMap<Integer, TreeMap<Integer, Double>> readData=new ReadHashmap().getReadHashmap(); //**********미리계산된 데이터 불러오기
			
			
			HashMap<Integer,Double> score = new HashMap<>(); //( 영화:(평점*가중치)누적 )
			HashMap<Integer,Double> totalSim = new HashMap<>(); //( 영화:가중치누적 )
			
			HashMap<Integer, Double> udata =userData.get(user);//추천해줄 고객key의 value영화,평점 
			int how=1;
			Iterator<Integer> iterUserList= udata.keySet().iterator(); //고객이 평가한 영화 iter
			while(iterUserList.hasNext()){ //user가 평가한 영화 루프
				int itrMyMovie=iterUserList.next();
				
				System.out.println((how++)+"/"+udata.size());//*******************************************진행 정도*************
				
				int size=data.get(itrMyMovie).size();
				int how2=1;
				
				Iterator<Integer> iterMovieids= data.get(itrMyMovie).keySet().iterator(); //영화전체비교 유사도 HashMap에서 본영화기준value의 key list (고객아이디, 평점)
				while(iterMovieids.hasNext()){	//itrMyMovie영화에 대한 유사도 리스트 전체 루프
					System.out.println("      "+(how2++)+"/"+size);
					int itrNoMovie=iterMovieids.next();
					
					if(itrMyMovie != itrNoMovie){ //루프 돌면서 내가 평가하지 않은 영화id 걸린다면
						double sim = 0.0;
						sim=data.get(itrMyMovie).get(itrNoMovie);//해당 유사도
						double mul=0.0;
						
						mul=(userData.get(user).get(itrMyMovie))*sim;
								//itrMovie의 user의 평점 * (itrMyMovie와 itrNoMovie의 유사도)
						
						if(score.get(itrNoMovie)==null){ //값이 없다면 그냥 추가하고
							score.put(itrNoMovie, mul);// (안본 영화코드:mul누적)
						}else{
							mul=(score.get(itrNoMovie))+mul;
							score.put(itrNoMovie, mul);
						}
						
						if(totalSim.get(itrNoMovie)==null){
							totalSim.put(itrNoMovie, sim);
						}else{
							sim=(totalSim.get(itrNoMovie))+sim;
							totalSim.put(itrNoMovie,sim);
						}
					}
				}	
			}
			//(유사도*가중치 총합)/(가중치 총합)
			
			ArrayList<PredictedRateVO> finalresult = new ArrayList<>();
			
			
			for(Integer key : score.keySet()){
				//result.add( new similarity(key, score.get(key)/totalSim.get(key)) );
				finalresult.add(new PredictedRateVO(key, (score.get(key)/totalSim.get(key)) ));
			}
			
			return finalresult;
		}
		
		
}
