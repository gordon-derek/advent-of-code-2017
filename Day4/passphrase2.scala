import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

var count = 0
for(line <- Source.fromFile("input.txt").getLines){
	var passcodes = new ListBuffer[String]()
	var passes = line.split("\\s+")
	breakable{
		for(pass <- passes){
			var word = pass.toCharArray.sorted
			if(passcodes.contains(word.mkString("")))
				break
			else
				passcodes.append(word.mkString(""))
			
		}
		count += 1
	}
}
println(count)