#!/usr/bin/ruby

sum = 0
iFile = File.new("input.txt","r")
if iFile
	content = iFile.read
	first = content[0].to_i
	for i in 1..content.length.to_i-1 do
		test = content[i] == content[i+1]
		sum += content[i].to_i if test
	end
	test = content[content.length-1].to_i == first
	sum += first if test
	puts sum
else 
	puts "Unable to open file"
end

