class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
       

    ArrayList<Integer> ans = new ArrayList<>();

    int m = arr.length;
    int n = arr[0].length;

    int firstRow = 0;
    int lastRow = m - 1;
    int firstCol = 0;
    int lastCol = n - 1;

    while (firstRow <= lastRow && firstCol <= lastCol) {


        for (int j = firstCol; j <= lastCol; j++) {
            ans.add(arr[firstRow][j]);
        }
        firstRow++;
        if(firstRow>lastRow || firstCol>lastCol) break;
        

     for (int i = firstRow; i <= lastRow; i++) {
            ans.add(arr[i][lastCol]);
        }
        lastCol--;
         if(firstRow>lastRow || firstCol>lastCol)break;


        for (int j = lastCol; j >= firstCol; j--) {
            ans.add(arr[lastRow][j]);
        }
        lastRow--;
         if(firstRow>lastRow || firstCol>lastCol)break;

   
        for (int i = lastRow; i >= firstRow; i--) {
            ans.add(arr[i][firstCol]);
        }
        firstCol++;
        //   if(firstRow>lastRow || firstCol>lastCol);

    }


    return ans;
    }
}