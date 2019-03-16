package dadacallcar;
import java.util.*;
public class Maincallcar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用答答打车系统");
		System.out.println("您是否要租车：1是 0否");
		Scanner inp1=new Scanner(System.in);
		int a=inp1.nextInt();
		if(a==0) {
			inp1.close();
			return ;
		}
		
		Car[] cararr= {
				new Bus(1,"奥迪A4",500,4,0),
				new Bus(2,"马自达6",400,4,0),
				new Pickup(3,"皮卡雪",450,4,2),
				new Bus(4,"金龙",800,20,0),
				new Truck(5,"松花江",400,0,4),
				new Truck(6,"依维柯",1000,0,20)
		};
		
		System.out.println("您可租车的类型及其价目表：");
		for(int i=0;i<cararr.length;i++)
		{
			System.out.println(cararr[i].getNumber()+"\t"
					+cararr[i].getName()+"\t"
					+cararr[i].getRent()+"\t"
					+cararr[i].getForpp()+"\t"
					+cararr[i].getForgood());
		}
		System.out.println("请输入您要租汽车的数量:");
		Scanner inp2=new Scanner(System.in);
		int b=inp2.nextInt();//b为租车数量
		int[] arrinp=new int[b];//arrinp为要租的车序号的数组
		
		for(int i=0;i<b;i++)
		{
			System.out.println("请输入第"+(i+1)+"辆车的序号：");
			Scanner inp0=new Scanner(System.in);
			int tempnumber=inp0.nextInt();
			arrinp[i]=tempnumber;
		}
		System.out.println("请输入租车天数:");
		Scanner rentday=new Scanner(System.in);
		int rentday_num=rentday.nextInt();
		System.out.println("您的账单:");
		System.out.println("***可载人的车有：");
		int forpptt=0;
		for(int i=0;i<b;i++)
		{
			for(int j=0;j<6;j++)
			{
				if(arrinp[i]==cararr[j].getNumber() && cararr[j].getForpp()!=0) {
					System.out.print(cararr[j].getName()+"\t");
					forpptt+=cararr[j].getForpp();
				}
				continue;
			}
		}
		System.out.println("共载人："+forpptt+"人");
		System.out.println("***载货的车有：");
		int forgoodtt=0;
		for(int i=0;i<b;i++)
		{
			for(int j=0;j<6;j++)
			{
				if(arrinp[i]==cararr[j].getNumber() && cararr[j].getForgood()!=0) {
					System.out.print(cararr[j].getName()+"\t");
					forgoodtt+=cararr[j].getForgood();
				}
				continue;
			}
		}
		System.out.println("共载货："+forgoodtt+"吨");
		int money=0;
		
		for(int i=0;i<b;i++)
		{
			for(int j=0;j<6;j++)
			{
				if(arrinp[i]==cararr[j].getNumber()) {
					money+=cararr[j].getRent();
				}
				continue;
			}
		}
		money=money*rentday_num;
		System.out.println("***共租车总价格："+money+"元");
			
		
		
		
		inp2.close();
		inp1.close();
	}

}
