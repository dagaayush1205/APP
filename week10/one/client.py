
import socket

def tcp_client():
    # Define server address and port
    server_address = ('localhost', 65432)  # Make sure this port matches the server's port
    
    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        # Connect to the server
        client_socket.connect(server_address)
        print("Connected to server.")

        # Send a message to the server
        message = "Hello, Server!"
        client_socket.sendall(message.encode())
        print("Message sent to server.")

        # Receive response from the server
        response = client_socket.recv(1024).decode()
        print("Received from server:", response)

# Run the client
if __name__ == "__main__":
    tcp_client()
