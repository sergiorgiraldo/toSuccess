from bs4 import BeautifulSoup
import requests
import re
import nltk

# extract all mail address from a given page
# method: find tags that contain email, get its text & run regular expression

def search_email(s):

	pattern = re.compile(r"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$")
	hasEmail = False;

	for entry in re.findall(pattern, s):
		print entry
		hasEmail = True

	return hasEmail


def crawl(link) :
	soup = BeautifulSoup(requests.get(link, verify = False).text)
	for link in soup.find_all('a'):
		if search_email(link.text) : continue
		print link.text
		crawl(link)


def main():
	# find all emails
	soup = BeautifulSoup(requests.get('https://tika.apache.org/mail-lists.html', verify = False).text)

	for link in soup.find_all('a'):
		search_email(link.text)


	# do crawling
	crawl('https://tika.apache.org/mail-lists.html')

if __name__ == '__main__' : 
	main()