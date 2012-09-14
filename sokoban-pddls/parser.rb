map = []

STDIN.read.split("\n").each do |a|
   map << a
end

n, m = map.length, map[0].length

def name(i, j)
  "s_#{i}_#{j}"
end
objects = []
adj_h = []
adj_v = []
players = []
boxes = []
goals = []

0.upto(n-1) { |i|
  0.upto(m-1) { |j|
    v = map[i][j]
    x = name(i, j)
    objects << x if v != "#"
    players << "(has_player #{x})" if v == "P"
    boxes << "(has_box #{x})" if v == "B"
    goals << "(has_box #{x})" if v == "G"

    next if v == "#"

    [i-1, i+1].each { |i2|
      adj_v << "(adjacent_v #{x} #{name(i2, j)})" if map[i2][j] != "#"
    }

    [j-1, j+1].each { |j2|
      adj_h << "(adjacent_h #{x} #{name(i, j2)})" if map[i][j2] != "#"
    }
  }
}
print %Q{(define (problem simple)
  (:domain sokoban-domain)
}
print "  (:objects #{objects.join(" ")})\n"
print "  (:init\n"
print "     #{adj_h.join(" ")})\n"
print "     #{adj_v.join(" ")})\n"
print "     #{players.first}\n"
print "     #{boxes.join(" ")})\n"
print "  (:goal #{goals.join(" ")})\n"

