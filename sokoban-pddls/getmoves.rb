STDIN.read.split("\n").each do |a|
  y0 = a[2].to_i
  x0 = a[4].to_i
  y1 = a[8].to_i
  x1 = a[10].to_i

  # p [[y0, x0], [y1, x1]]


  dy = [1, 0, -1,  0]
  dx = [0, 1,  0, -1]

  0.upto(3) { |ix|
    p ix if [y0 + dy[ix], x0 + dx[ix]] == [y1, x1]
  }
end

