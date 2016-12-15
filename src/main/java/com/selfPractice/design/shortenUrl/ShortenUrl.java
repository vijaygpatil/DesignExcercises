package com.selfPractice.design.shortenUrl;

public class ShortenUrl {
	// C++ prgram to generate short url from intger id and
	// integer id back from short url.
	// Function to generate a short url from intger ID
	static String idToShortURL(int n) {
		// Map to store 62 possible characters
		char[] map = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
				'3', '4', '5', '6', '7', '8', '9' };

		StringBuilder shorturl = new StringBuilder();

		// Convert given integer id to a base 62 number
		while (n > 0) {
			// use above map to store actual character
			// in short url
			shorturl.append(map[n % 62]);
			n = n / 62;
		}

		// Reverse shortURL to complete base conversion
		shorturl.reverse();

		return shorturl.toString();
	}

	// Function to get integer ID back from a short url
	static int shortURLtoID(String shortURL) {
		int id = 0; // initialize result

		// A simple base conversion logic
		for (int i = 0; i < shortURL.length(); i++) {
			if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
				id = id * 62 + shortURL.charAt(i) - 'a';
			if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
				id = id * 62 + shortURL.charAt(i) - 'A' + 26;
			if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
				id = id * 62 + shortURL.charAt(i) - '0' + 52;
		}
		return id;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int n = 12345;
		String shorturl = idToShortURL(n);
		System.out.println("Generated short url is " + shorturl);
		System.out.println("Id from url is " + shortURLtoID(shorturl));
	}

}
