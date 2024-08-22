package problem2112;

import java.util.Scanner;

public class solution2 {

    static int W;
    static int D;
    static int K;
    static boolean isPassed;
    
     public static void main(String[] args) {
        
         Scanner sc = new Scanner(System.in);
         
         int T = sc.nextInt();
         
         for (int test_case = 1; test_case <= T; test_case++) {
             isPassed = false;
             // 두께 D
             // 가로크기 W
             // 합격기준 K 가 주어진다.
             
             D = sc.nextInt();    // 두께 6
             W = sc.nextInt();    // 가로 8
             K = sc.nextInt();    // 합격 3
             
             int[][] arr = new int[D][W];
             
             // A : 0, B : 1 
             for (int i=0; i < D; i++) {
                 for (int j=0; j<W; j++) {
                     arr[i][j] = sc.nextInt();
                 }
             }
             
             int count = 0;
             
             // 첫 번째 인수는 'n' 번 줄에 어떤 약물을 넣고, 앞으로 몇번 더 약물을 넣을 수 있는지?
             // 두 번째 인수는 n 번 줄에 '어떤 약물'을 넣고, 앞으로 몇번 더 약물을 넣을 수 있는지?
             // 세 번째 인수는 n 번 줄에 어떤 약물을 넣고, 앞으로 '몇번' 더 약물을 넣을 수 있는지?

             // isPassed = true 가 될 때 까지 실행함
             
             while (true) {
                     btk(0,0,count,arr);
                     if(!isPassed)
                    	 break;
                     count++;
             }
             
             
             System.out.println("#" + test_case + " " + count);
         }
    }
     
     
     // 투약하는 메서드
     // 주의 : 투약은 가로로 한다.
     static int[][] dropDrug(int row, int drugType, int[][] array) {
         for (int c=0; c<W; c++) {
             array[row][c] = drugType;
         }
         return array;
     }
     
     // 2차원 배열 전체 검사하기
     static boolean check(int[][] array) {
        int count = 0; 
         
        // 바깥 for문 : column 변경
         for (int j=0; j < W; j++) {
             boolean lineChecked = false;
             count = 1;    // column 바꿀때마다 count 초기화
             
             // 내부 for문 : row 변경
             for (int i=1; i<D; i++) {
                 if (array[i][j] == array[i-1][j]) {
                     count++;
                 } else {
                     count = 1;
                 }
            
                 // 세로줄에서 count가 K에 도달하면, 즉 테스트를 통과하면 다음 라인으로 바로 넘어간다.
                 if (count == K) {
                     lineChecked = true;
                     break;
                 }
                 
             }
             // 한 줄 검사가 끝난 시점.
             // 이번 검사가 통과하지 못했다면 바로 false 반환
             if (!lineChecked) return false;
         }
         
         // 모든 검사가 끝날때까지 return이 일어나지 않았다면, 즉 모든 검사가 통과했다면
         // 참을 반환
         isPassed = true;
         return true;
     }
     
     // 첫 번째 인수는 'n' 번 줄에 어떤 약물을 넣을것인가?
     // 두 번째 인수는 n번 줄에 '어떤 약물'을 넣을것인가? case는 -1(넣지않음) , 0(특성A), 1(특성B) 가 있음.
     // 세 번째 인수는 n 번 줄에 어떤 약물을 넣고, 앞으로 '몇번' 더 약물을 넣을 수 있는지?
     static void btk(int row, int drugType, int chance, int[][] array) {
        
         // 내가 만약 D번줄까지 있는데, 지금 row번줄이고 (최대 D - row + 1번 더 투약할수있고), chance가 D - row + 1개보다 많이 남앗다면, 그냥 return 해도 된다.
         // 내가 만약 10번줄까지 있는데, 지금 7번줄이고 (최대 4번 더 투약할수있고), chance가 4 개보다 많이 남앗다면, 그냥 return 해도 된다.
         if (chance > D - row + 1) return;    // 시간 단축용
         
         // boundary 를 넘어가면 취소한다.
         if (row == D) return;
         
         // 투약부터 하고
         if (drugType == 0) {
             array=dropDrug(row, 0, array);
             chance--;
         } else if (drugType == 1) {
             array=dropDrug(row, 1, array);
             chance--;
         } 
         
         
         // 약물 투약 기회를 다 썼다면, 검사를 한다.
         //
         if (chance == 0) {
             check(array);
             return ;
         } else {
             // 끝나지 않았다면, 다음 케이스를 생각해본다.
             // 다음 줄에 약물A를 넣는 경우
             btk(row+1, 0, chance, array);
             
             // 다음 줄에 약물B를 넣는 경우
             btk(row+1, 1, chance, array);
             
             // 다음 줄에 약물을 안넣는 경우
             btk(row+1, -1, chance, array);    
         }
     }
}




// 짜야 하는 로직
// 1. 0번 줄에 약물을 넣을것인가 말것인가
// 0번 줄에 약물을 넣었다면, 1번 줄에 약물을 넣을것인가 말것인가
// 0번 줄에 약물을 넣지 않았다면, 1번줄에 약물을 넣을것인가 말것인가?