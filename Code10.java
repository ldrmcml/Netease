package Netease;

import java.util.ArrayList;

class Range{
	int left;
	int right;
	public Range(int num1,int num2){
		left=num1;
		right=num2;
	}
	public String toString() {
		return "Range [left=" + left + ", right=" + right + "]";
	}
}
public class Code10 {
	public static void main(String[] args){
		Range r1=new Range(4,8);
		Range r2=new Range(9,13);
		Range r3=new Range(2,4);
		Range r4=new Range(6,12);
		Range[] aR=new Range[]{r1,r2};
		Range[] bR=new Range[]{r3,r4};
		ArrayList<Range> result=getRangeSet(aR,bR);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
	public static ArrayList<Range> getRangeSet(Range[] aR,Range[] bR){
		ArrayList<Range> ranges=new ArrayList<Range>();
		for(int i=0,j=0;i<aR.length&&j<bR.length;){
			while(i<aR.length&&j<bR.length&&aR[i].right<=bR[j].left){i++;}
			while(i<aR.length&&j<bR.length&&aR[i].left>=bR[j].right){j++;}
			if(i>=aR.length||j>=bR.length)break;
			Range r=new Range(Math.max(aR[i].left, bR[j].left), Math.min(aR[i].right, bR[j].right));
			ranges.add(r);
			if(aR[i].right<bR[j].right){
				i++;
			}else if(aR[i].right>bR[j].right){
				j++;
			}else{
				i++;
				j++;
			}
		}
		return ranges;
	}
	public static ArrayList<Range> getRangeSet1(Range[] aR,Range[] bR){
		ArrayList<Range> ranges=new ArrayList<Range>();
		for(int i=0;i<bR.length;i++){
			for(int j=0;j<aR.length;j++){
				if(aR[j].right<bR[i].left){
					break;
				}else if(aR[j].right>bR[i].left){
					int left=aR[j].left>bR[i].left?aR[j].left:bR[i].left;//选大的那个
					int right=aR[j].right<bR[i].right?aR[j].right:bR[i].right;
					Range range=new Range(left,right);
					ranges.add(range);
				}
			}
		}
		return ranges;
	}
}
