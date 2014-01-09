package oj;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] searchRange(int[] A, int target) {
        int left = findLeftBound(A, 0, A.length - 1, target);
        int right = findRightBound(A, 0, A.length - 1, target);
        return new int[]{left, right};
    }
    int findLeftBound(int A[], int start, int last, int target) {
        while ( start < last ) {
            int mid = (start + last) / 2;
            if ( A[mid] == target ) last = mid - 1;
            else start = mid + 1;
        }
        if ( A[start] == target ) return start;
        else return start + 1;
    }
    int findRightBound(int A[], int start, int last, int target) {
        while ( start < last ) {
            int mid = (start + last) / 2;
            if ( A[mid] == target ) start = mid + 1;
            else last = mid - 1;
        }
        if ( A[start] == target ) return start;
        else return start - 1;
    }
    
    public int[] searchRange2(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        if(A.length == 1) {
            if(target == A[0]) 
                return new int[]{0,0};
            else 
                return new int[] {-1, -1};
        }
        while(low < high) {
            mid = (high + low)/2;
            if(A[mid] == target) {
               return searchHelper(A, mid, target);
            }
            else if(A[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        if((mid + 1 < A.length) && A[mid + 1] == target) {
            return searchHelper(A, mid + 1, target);
        }
        else
            return new int[]{-1, -1};
    }
    public int[] searchHelper(int[] A, int mid, int target) {
        int left = mid;
        int right = mid;
        while(left >= 0 && A[left] == target) {
            left--;
        }
        left++;
            
        while(right < A.length && A[right] == target) {
            right++;
        }
        right--;
        return new int[]{left, right};
    }
}
