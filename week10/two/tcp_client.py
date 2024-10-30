import socket
import json

def tcp_client():
    # Define server address and port
    server_address = ('localhost', 65432)
    
    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        # Connect to the server
        client_socket.connect(server_address)
        print("Connected to server.")

        # Send a list of numbers to the server
        numbers = [10, 20, 30, 40, 50]
        message = json.dumps(numbers)  # Convert list to JSON format
        client_socket.sendall(message.encode())
        print("List of numbers sent to server:", numbers)

        # Receive sum of numbers from the server
        response = client_socket.recv(1024).decode()
        print("Sum received from server:", response)

# Run the client
if __name__ == "__main__":
    tcp_client()

