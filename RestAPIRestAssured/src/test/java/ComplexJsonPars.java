import files.payload;

import io.restassured.path.json.JsonPath;

public class ComplexJsonPars {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(payload.CoursePrice());

		int count = js.getInt("courses.size");

		System.out.println(count);

		int totaoAmount = js.getInt("dashboard.purchaseAmount");

		System.out.println(totaoAmount);

		int sum = 0;

		for (int i = 0; i < count; i++) {

			String courseTitles = js.get("courses[" + i + "].title");

			int coursePrice = js.get("courses[" + i + "].price");

			int quantity = js.get("courses[" + i + "].copies");

			sum += coursePrice * quantity;

			System.out.println(courseTitles + " - " + coursePrice);

			if ("RPA".equals(courseTitles)) {

				System.out.println(js.get("courses[" + i + "].copies").toString());

			}

		}

		System.out.println(sum);

		if (totaoAmount == sum) {

			System.out.println("Equal");

		}

	}

}