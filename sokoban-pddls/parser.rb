map = []

STDIN.read.split("\n").drop(2).each do |a|
   map << a
end

n, m = map.length, map[0].length

def name(i, j)
  "s_#{i}_#{j}"
end
objects = []
adj = []
adj_2 = []
players = []
boxes = []
goals = []

0.upto(n-1) { |i|
  0.upto(m-1) { |j|
    v = map[i][j]
    x = name(i, j)
    objects << x if v != "#"
    players << "(has_player #{x})" if v == "$"
    boxes << "(has_box #{x})" if v == "o"
    goals << "(has_box #{x})" if v == "_"

    next if v == "#"

    dy = [1, 0, -1,  0]
    dx = [0, 1,  0, -1]

    0.upto(3) { |ix|
      i2 = i + dy[ix]
      j2 = j + dx[ix]
      adj << "(adjacent #{x} #{name(i2, j2)})" if map[i2][j2] != "#"
    }

    0.upto(3) { |ix|
      i2 = i + dy[ix] * 2
      j2 = j + dx[ix] * 2
      next if i2 < 0 || j2 < 0 || i2 >= n || j2 >= m
      adj_2 << "(adjacent_2 #{x} #{name(i2, j2)})" if map[i2][j2] != "#"
    }
  }
}
print %Q{(define (problem simple)
  (:domain sokoban-domain)
}
print "  (:objects #{objects.join(" ")})\n"
print "  (:init\n"
print "     #{adj.join(" ")}\n"
print "     #{adj_2.join(" ")}\n"
print "     #{players.first}\n"
print "     #{boxes.join(" ")})\n"
print "  (:goal #{goals.join(" ")})\n"
print ")\n"

