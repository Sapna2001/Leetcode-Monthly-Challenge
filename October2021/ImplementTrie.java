/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various 
applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Link: https://leetcode.com/problems/implement-trie-prefix-tree/
*/

class Trie {

	private TrieNode root;

	private class TrieNode {
		private TrieNode[] children = null;
		private boolean isWord;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode iterator = root;
		for (char ch : word.toCharArray()) {
			int indexInTrieNode = ch - 'a';
			if (iterator.children[indexInTrieNode] == null) {
				iterator.children[indexInTrieNode] = new TrieNode();
			}
			iterator = iterator.children[indexInTrieNode];
		}

		iterator.isWord = true;
	}

	public boolean search(String word) {
		TrieNode iterator = root;
		for (char ch : word.toCharArray()) {
			int indexInTrieNode = ch - 'a';
			if (iterator.children[indexInTrieNode] == null) {
			    return false;
			} else {
				iterator = iterator.children[indexInTrieNode];
			}
		}

		return iterator.isWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode iterator = root;
		for (char ch : prefix.toCharArray()) {
			int indexInTrieNode = ch - 'a';
			if (iterator.children[indexInTrieNode] == null) {
				return false;
			} else {
				iterator = iterator.children[indexInTrieNode];
			}
		}

		return true;
	}
}

