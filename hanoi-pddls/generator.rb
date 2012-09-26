# Example usage:
#
# $ ruby generator.rb 4 | ./blackbox -o hanoi-domain.pddl -f /dev/stdin

n = ARGV[0].to_i

class Array
  def jn
    join " "
  end
end

objects = (1..n).map { |i| "d#{i}" }
disks = objects.map { |d| "(disk #{d})" }
clears = %w{(clear p1) (clear p2) (clear d1)}
dons = (1...n).map { |i| "(on d#{i} d#{i+1})" }
ons = dons + ["(on d#{n} p3)"]
psmallers = (1..n).map { |i| (1..3).map { |j| "(smaller d#{i} p#{j})"} }.flatten
dsmallers = (1..n).map { |i| (1...i).map { |j| "(smaller d#{j} d#{i})"} }.flatten

goal = (dons + ["(on d#{n} p1)"]).shuffle

print "(define (problem hanoi-#{n})"
print "  (:domain hanoi-domain)"
print "  (:objects p1 p2 p3 #{objects.jn})\n"
print "  (:init\n"
print "     #{disks.jn}\n"
print "     #{clears.jn}\n"
print "     #{ons.jn}\n"
print "     #{dsmallers.jn}\n"
print "     #{psmallers.jn}\n"
print "  )\n"
print "  (:goal (and #{goal.jn}))\n"
print ")\n"
