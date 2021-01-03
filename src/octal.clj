(ns octal)

#_"number -> octal map [string-number octal-constant base-n] -> sum -> check"

(defn- validate-arg [str-n]
  (zero? (count (remove #{\0 \1 \2 \3 \4 \5 \6 \7} str-n))))

(defn- process-octal-map [^java.lang.Character n
                         ^java.lang.Integer oc
                         ^java.lang.Integer b]
  (* (new java.lang.Integer (str n))
     (Math/pow oc b)))

(defn to-decimal [^java.lang.Integer n]
  (let [str-n (str n)
        argument-validation (validate-arg str-n)]
    (if argument-validation
      (let [octal-map (map process-octal-map
                           str-n
                           (repeat 8)
                           (reverse (range (count str-n))))
            sum-of-octal-map (int (reduce + octal-map))]
        sum-of-octal-map)
      0)))
