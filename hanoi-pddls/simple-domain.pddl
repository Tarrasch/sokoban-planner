(define (domain simple)
  (:requirements :equality)
  (:predicates (p1 ?x) (p2 ?x) (p3 ?x) (p4 ?x))
  (:action first-action
           :parameters (?x)
           :effect (p1 ?x)
  )
  (:action second-action
           :parameters (?x)
           :precondition (p1 ?x)
           :effect (and (p3 ?x))
  )
  (:action third-action
           :parameters (?x)
           :precondition (p3 ?x)
           :effect (and (p4 ?x))
  )
)

