package com.yingjie.nowcoder;


import java.util.Scanner;

/**
 * HJ16 购物单
 *
 * <a href="https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&tqId=21239&rp=1&ru=/ta/huawei&qru=/ta/huawei&difficulty=&judgeStatus=&tags=/question-ranking">...</a>
 */
public class HJ0016 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int money = sc.nextInt();
            int n = sc.nextInt();
            if(n <= 0 || money <= 0) System.out.println(0);

            good[] Gs = new good[n + 1];
            for (int i = 1; i <= n; i++) {
                int v = sc.nextInt();
                int p = sc.nextInt();
                int q = sc.nextInt();
                Gs[i] = new good(v,p,q);
            }
            for (int i = 1; i <= n; i++) {
                if(Gs[i].q > 0){
                    if(Gs[Gs[i].q].a1==0){
                        Gs[Gs[i].q].setA1(i);
                    }else {
                        Gs[Gs[i].q].setA2(i);
                    }
                }
            }

            int[][] dp = new int[n+1][money+1];
            for (int i = 1; i <= n; i++) {
                int v=0, v1=0, v2=0, v3=0, tempdp=0, tempdp1=0, tempdp2=0, tempdp3=0;

                // 只有主件
                v = Gs[i].v;
                tempdp = Gs[i].p * v;
                // 主件加附件1
                if(Gs[i].a1 != 0){
                    v1 = Gs[Gs[i].a1].v + v;
                    tempdp1 = tempdp + Gs[Gs[i].a1].v * Gs[Gs[i].a1].p;
                }
                // 主件加附件2
                if(Gs[i].a2 != 0){
                    v2 = Gs[Gs[i].a2].v + v;
                    tempdp2 = tempdp + Gs[Gs[i].a2].v * Gs[Gs[i].a2].p;
                }
                // 主件加附件1和附件2
                if(Gs[i].a1 != 0 && Gs[i].a2 != 0){
                    v3 = Gs[Gs[i].a1].v + Gs[Gs[i].a2].v + v;
                    tempdp3 = tempdp + Gs[Gs[i].a1].v*Gs[Gs[i].a1].p + Gs[Gs[i].a2].v*Gs[Gs[i].a2].p;
                }

                for(int j=1; j<=money; j++){
                    // 当物品i是附件时,相当于跳过
                    if(Gs[i].q > 0) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                        if(j >= v && v != 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v] + tempdp);
                        if(j >= v1 && v1 != 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v1] + tempdp1);
                        if(j >= v2 && v2 != 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v2] + tempdp2);
                        if(j >= v3 && v3 != 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v3] + tempdp3);
                    }
                }
            }
            System.out.println(dp[n][money]);
        }
    }


    /**
     * 定义物品类
     */
    private static class good{
        public int v;  //物品的价格
        public int p;  //物品的重要度
        public int q;  //物品的主件ID

        public int a1=0;   //附件1ID
        public int a2=0;   //附件2ID

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}
