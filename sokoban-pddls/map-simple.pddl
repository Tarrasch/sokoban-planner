(define (problem simple)
  (:domain sokoban-domain)
  (:objects s_1_1 s_1_2 s_1_3 s_2_2)
  (:init
     (adjacent_h s_1_1 s_1_2) (adjacent_h s_1_2 s_1_1) (adjacent_h s_1_2 s_1_3) (adjacent_h s_1_3 s_1_2))
     (adjacent_v s_1_2 s_2_2) (adjacent_v s_2_2 s_1_2))
     (has_player s_1_1)
     (has_box s_1_2))
  (:goal (has_box s_1_3))
