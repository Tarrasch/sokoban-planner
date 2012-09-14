(define (domain sokoban-domain)
  (:requirements :equality)
  (:predicates (has_player ?x)
               (has_box ?x)
               (adjacent_v ?x ?y)
               (adjacent_h ?x ?y))
  (:action push-box
		   :parameters (?x ?y ?z)
		   :precondition (and (has_player ?x)
                          (has_box ?y)
                          (not (has_box ?z))
                          (not (= ?x ?z))
                          (or (and (adjacent_v ?x ?y)
                                   (adjacent_v ?y ?z))
                              (and (adjacent_h ?x ?y)
                                   (adjacent_h ?y ?z))))
	       :effect (and (has_box ?z)
						(not(has_box ?y))
						(has_player ?y)
						(not(has_player ?x))))
  (:action move-player
           :precondition (and (or (adjacent_v ?x ?y)
                                  (adjacent_h ?x ?y))
                              (not (has_box ?y))
                              (has_player ?x))
           :effect		   (and (has_player ?y)
                              (not (has_player ?x))))
           :parameters (?x ?y)

  )