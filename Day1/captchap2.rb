#!/usr/bin/ruby

sum = 0
iFile = File.new("input.txt","r")
if iFile
	content = iFile.read
	offset = (content.length.to_i)/ 2
	puts offset
	for i in 0..offset do
		#puts content[i]
		#puts content[i+offset]
		test = content[i] == content[i+offset]
		#puts test
		sum += content[i].to_i*2 if test
	end
	puts sum
else 
	puts "Unable to open file"
end
