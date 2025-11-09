package Binary_Search_4;

public class Allocate_Books {

	public static void main(String[] args) {
		int[] books = { 12, 34, 67, 90 }; // pages in each book
		int students = 2; // number of students

		int result = BinarySearch(books, students);
		System.out.println("Minimum possible maximum pages = " + result);

	}

	private static int BinarySearch(int[] books, int students) {
		int n = books.length;
		if(n < students) return -1;
		int low = -1;
		int high = 0;
		for(int book : books) {
			low = Math.max(low,book);
			high += book;
		}
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(Compute(books,students,mid)) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static boolean Compute(int[] books, int students, int MaxPages) {
		int studentCount = 1;
		int pageCount = 0;
		for(int i = 0;i<books.length;i++) {
			if(pageCount + books[i] <= MaxPages) {
				pageCount += books[i];
			}else {
				studentCount++;
				pageCount = books[i];
			}
		}
		return studentCount <= students;
	}

}
