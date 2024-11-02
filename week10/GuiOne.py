from pyDatalog import pyDatalog

# Initialize pyDatalog
pyDatalog.clear()

# Define terms and variables
pyDatalog.create_terms('Item, Quantity, Price, InventoryValue, TotalInventoryValue, Stock, ReorderPoint, Sales, NewQuantity')
pyDatalog.create_terms('Value, X, Y')  # Additional terms for calculations

# Define items with initial quantities and prices
+Item('apple', 100, 0.5)
+Item('banana', 80, 0.3)
+Item('orange', 50, 0.6)

# Define reorder points
+ReorderPoint('apple', 20)
+ReorderPoint('banana', 15)
+ReorderPoint('orange', 10)

# Calculate inventory value for each item
InventoryValue(Item, Value) <= Item(Item, Quantity, Price) & (Value == Quantity * Price)

# Calculate total inventory value by summing individual inventory values
TotalInventoryValue(Value) <= (Value == sum_(Y, for_each=InventoryValue(Item, Y)))

# Simulate a sale and update inventory levels
def simulate_sale(item_name, quantity_sold):
    # Retrieve current stock and price
    for stock, price in Item(item_name, X, Y):
        if stock >= quantity_sold:
            NewStock = stock - quantity_sold
            +Item(item_name, NewStock, price)  # Add updated stock level
            -Item(item_name, stock, price)     # Remove the old stock level
            print(f"Sale completed: {quantity_sold} {item_name}(s) sold.")
        else:
            print(f"Insufficient stock for {item_name}.")

# Queries
# 1. Inventory Value Query
print("Inventory Values per item:", InventoryValue(Item, _).data)

# 2. Total Inventory Value
print("Total Inventory Value:", TotalInventoryValue(_).data)

# 3. Simulate a sale of 10 apples
simulate_sale('apple', 10)

# 4. Check stock levels for reorder points
def check_reorder():
    for item, stock, _ in Item.data:
        reorder_level = ReorderPoint(item)[0][0]
        if stock <= reorder_level:
            print(f"Reorder needed for {item} (current stock: {stock})")

check_reorder()

