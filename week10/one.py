from pyDatalog import pyDatalog

pyDatalog.create_terms('Item, Quantity, Price, InventoryValue, TotalInventoryValue, Stock, ReorderPoint, Sales, Restock, NewQuantity')

# Define items and quantities
+ Item('apple', 100, 0.5)
+ Item('banana', 80, 0.3)
+ Item('orange', 50, 0.6)

# Define reorder points (when stock falls below these levels, reorder is required)
+ ReorderPoint('apple', 20)
+ ReorderPoint('banana', 15)
+ ReorderPoint('orange', 10)

# Calculate inventory value for each item
InventoryValue(Item, Quantity, Price) <= Item(Item, Quantity, Price) & (InventoryValue == Quantity * Price)

# Calculate total inventory value
TotalInventoryValue() == sum_(InventoryValue)

# Simulate a sale and update inventory levels
Sales(Item, Quantity) <= (Item(Item, Stock, Price)) & (NewQuantity == Stock - Quantity) & (Item(Item, NewQuantity, Price))
Restock(Item, Quantity) <= (Item(Item, Stock, Price)) & (NewQuantity == Stock + Quantity) & (Item(Item, NewQuantity, Price))

# Queries
# 1. Inventory Value Query
print(InventoryValue(Item, Quantity, Price).data)

# 2. Total Inventory Value
print("Total Inventory Value:", TotalInventoryValue().data)

# 3. Simulate a sale of 10 apples
Sales('apple', 10)

# 4. Check stock levels for reorder points
def check_reorder():
    for item, stock, _ in Item.data:
        reorder_level = ReorderPoint(item)[0][0]
        if stock <= reorder_level:
            print(f"Reorder needed for {item} (stock level: {stock})")

check_reorder()

