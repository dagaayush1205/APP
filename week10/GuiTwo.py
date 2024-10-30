
from pyDatalog import pyDatalog

pyDatalog.create_terms('X, Y, Z, Parent, Child, Sibling, Grandparent, Ancestor, Degree, Cousin')

# Define parent-child relationships as facts
+ Parent('John', 'Alice')
+ Parent('John', 'Bob')
+ Parent('Alice', 'Charlie')
+ Parent('Alice', 'Daisy')
+ Parent('Bob', 'Eve')

# Rule 1: Siblings share at least one parent
Sibling(X, Y) <= Parent(Z, X) & Parent(Z, Y) & (X != Y)

# Rule 2: Grandparents are parents of parents
Grandparent(X, Y) <= Parent(X, Z) & Parent(Z, Y)

# Rule 3 & 4: Calculate degree of relationship based on common ancestors
Degree(X, Y, 1) <= Parent(X, Y) | Parent(Y, X)
Degree(X, Y, Degree) <= Parent(X, Z) & Degree(Z, Y, Degree-1)

# Rule to find common ancestors
Ancestor(X, Y) <= Parent(X, Y)
Ancestor(X, Y) <= Parent(X, Z) & Ancestor(Z, Y)

# Find common ancestor of two individuals
def earliest_common_ancestor(a, b):
    for ancestor in (Ancestor(a, X) & Ancestor(b, X)).data:
        print(f"Common ancestor: {ancestor[0]}")

# Adding family members
def add_family_member(parent, child):
    +Parent(parent, child)

# Finding cousins
Cousin(X, Y, Degree) <= Degree(X, Y, Degree) & (Degree >= 3)

# Generate a family tree with Graphviz
def draw_family_tree():
    import graphviz
    dot = graphviz.Digraph()
    for (parent, child) in Parent.data:
        dot.edge(parent, child)
    dot.render("family_tree", format="png")

# Queries and test cases
# 1. Find all siblings of 'Alice'
print(Sibling('Alice', X).data)

# 2. Find all grandparents of 'Charlie'
print(Grandparent(X, 'Charlie').data)

# 3. Add a new family member
add_family_member('Eve', 'George')

# 4. Find all cousins of 'Charlie'
print(Cousin('Charlie', X, 3).data)

# 5. Find the earliest common ancestor between 'Alice' and 'Bob'
earliest_common_ancestor('Alice', 'Bob')

# Generate family tree
draw_family_tree()
