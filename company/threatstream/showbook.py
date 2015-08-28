import MySQLdb
import sys

db = MySQLdb.connect(host="localhost", # your host, usually localhost
                     user="root", # your username
                      passwd="", # your password
                      db="book") # name of the data base

def showbooks(db):
	cur = db.cursor() 
	try:
		# first order and concatenate author's name by isbn, and then use the result to do a inner join with the book table
		cur.execute("SELECT * FROM book INNER JOIN (SELECT author.isbn, GROUP_CONCAT(DISTINCT author.name ORDER BY author.rank ASC SEPARATOR '%') FROM author GROUP BY author.isbn) AS x ON book.isbn= x.isbn")
		for row in cur.fetchall() :
			print "------------------------------------------------------"
			print row[1]
			for author in row[5].split("%"):
				print "  ", author
			sys.stdout.write(row[2])
			sys.stdout.write(",")
			print row[3]
			
	except: # catch *all* exceptions
		e = sys.exc_info()[0]
		print e

def main():
	showbooks(db);

if __name__=="__main__":main()
