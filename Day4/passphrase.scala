import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

var count = 0
for(line <- Source.fromFile("input.txt").getLines){
	var passcodes = new ListBuffer[String]()
	var passes = line.split("\\s+")
	breakable{
		for(pass <- passes){
			if(passcodes.contains(pass))
				break
			else
				passcodes.append(pass)
			
		}
		count += 1
	}
}
println(count)