# 22 - Bits, Number Theory, and Randomized Algorithms

[Curriculum](README.md) | Prerequisites: 01-03, 11

## Bit representation is part of the algorithm

Java ints use 32 bits and longs use 64. `&`, `|`, and `^` implement bitwise AND, OR, and XOR. `~` complements every bit. `>>` preserves the sign bit; `>>>` shifts in zeros. Java masks the shift distance to five bits for int and six for long, so `1 << 32` is not a 33-bit value. Use `1L << bit` only within the intended long bit range.

For a positive integer x, `x & (x-1)` clears its lowest set bit and `x & -x` isolates it. Therefore `x>0 && (x & (x-1))==0` tests positive powers of two. Zero must be excluded. Fixed-width overflow and signed interpretation matter at the highest bit.

XOR is associative, `x^x=0`, and `x^0=x`. Consequently, when every value occurs exactly twice except one, XOR of all values returns that singleton. This proof depends on the multiplicity promise; it does not solve arbitrary duplicate detection.

A bitmask represents a subset of a small indexed universe. Membership tests one bit; insertion sets it; removal clears it. Enumerating all masks is `2^n`, regardless of compact representation. To enumerate nonempty submasks of mask m, repeatedly use `(s-1)&m` starting from m and stop before cycling after zero. Across all masks, enumerating every submask takes `Theta(3^n)`, since each bit can be outside m, inside m only, or inside both m and s.

## GCD and modular arithmetic

Euclid's identity is `gcd(a,b)=gcd(b,a mod b)`: common divisors are unchanged by subtracting multiples of b. Repeating until b is zero takes `O(log min(a,b))` remainder operations for positive inputs. Handle zero inputs and signed minimum values deliberately; taking an absolute value can overflow.

Compute `lcm(a,b)` for positive values as `(a/gcd(a,b))*b` to reduce intermediate magnitude, then still check overflow. Define the zero case separately.

Residues modulo positive m support addition and multiplication, with normalization for negative values. Division requires a modular inverse, which exists exactly when the divisor is coprime with m. Extended Euclid finds coefficients satisfying `a*x+m*y=gcd(a,m)`, providing an inverse when the gcd is one. Fermat's `a^(p-2)` inverse shortcut requires prime p and a not divisible by p.

Binary exponentiation computes `a^e` using `O(log(e+1))` multiplications by repeatedly squaring and consuming exponent bits. Reducing modulo m bounds residues but does not necessarily prevent the **product before reduction** from overflowing. Use a safe multiplication strategy or a type justified by the modulus.

The sieve of Eratosthenes marks multiples of primes, beginning at `p*p` because smaller multiples were already handled. It finds primes through N in `O(N log log N)` time and `O(N)` storage in the standard analysis. Test `p<=N/p` instead of an overflowing square in loop bounds. A smallest-prime-factor table supports repeated factorization queries.

## Probability needed for algorithms

A probability statement needs an experiment and sample space. Conditional probability changes the information available; independence must be justified rather than inferred from separate-looking events. Linearity of expectation says `E[X+Y]=E[X]+E[Y]` even without independence, making indicator variables useful for expected counts.

A **Las Vegas** randomized algorithm always returns a correct result but has random runtime, as with randomized quicksort. A **Monte Carlo** algorithm has a controlled chance of error, as with an unverified fingerprint comparison. A probability bound for one comparison does not automatically hold for millions of comparisons; a union bound can bound the probability of any error by the sum of individual error probabilities.

## Uniform shuffling and reservoir sampling

Fisher-Yates shuffling walks i from `n-1` down to one, chooses j uniformly from `[0,i]`, and swaps positions i and j. Each position receives a uniform choice from the remaining items, so each permutation has probability `1/n!`. Swapping each position with a random index from the whole array does not generally have the same distribution.

For selecting one item uniformly from an unknown-length stream, keep the first item, then replace the current choice with item t with probability `1/t`. Item i is selected at arrival with probability `1/i`; it survives later steps with product `(i/(i+1))*...*((n-1)/n)=i/n`, giving final probability `1/n`. Store only the sample and count.

For a sample of k items, retain the first k; at step t>k, choose an integer uniformly in `[0,t)`, replacing that slot only if it is below k. An induction establishes a uniform k-subset. Use an appropriate bounded random API; taking a random integer modulo a bound can introduce bias. A fixed seed helps reproduce tests but does not prove distribution correctness.

## Practice

1. Find the two singleton values when all others occur twice, using one differing XOR bit.
2. Implement modular exponentiation with explicitly stated numeric bounds.
3. Prove the reservoir retention probability for an item already stored.
4. Enumerate all permutations for a tiny shuffle and compare exact outcome counts for correct and biased procedures.

<details><summary>Hints and checkpoints</summary>

1. XOR all entries; use a set bit to partition them, then XOR within each group.
2. The product of two residues must fit, or multiplication needs additional work.
3. An old item survives step t with probability `1-1/t` for a size-one reservoir.
4. Exhaustive enumeration of random-choice paths is stronger than a few empirical histograms for tiny n.

</details>

**Explain aloud:** “The correctness proof holds for every random choice; randomness changes the expected amount of work.” Vocabulary: residue, coprime, bitmask, uniform, expected value, independence, collision probability.

## Sources

- [Java Language Specification, expressions](https://docs.oracle.com/javase/specs/jls/se21/html/jls-15.html): shifts, integer operations, and evaluation rules.
- [MIT Mathematics for Computer Science readings](https://ocw.mit.edu/courses/6-042j-mathematics-for-computer-science-spring-2015/pages/readings/): number theory, counting, and probability.
- [Competitive Programmer's Handbook, Antti Laaksonen](https://cses.fi/book/book.pdf): bit manipulation, number theory, and probability; code there uses C++, so translate language semantics carefully.
