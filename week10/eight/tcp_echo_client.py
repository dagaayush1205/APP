
import socket

def tcp_echo_client():
    # Define server address and port
    server_address = ('localhost', 65437)

    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        # Connect to the server
        client_socket.connect(server_address)
        print("Connected to echo server.")

        while True:
            # Get message from the user
            message = input("Enter message to send (or 'exit' to quit): ")
            if message.lower() == 'exit':
                break

            # Send message to server
            client_socket.sendall(message.encode())

            # Receive echoed message from server
            response = client_socket.recv(1024)
            print("Echoed back from server:", response.decode())

# Run the client
if __name__ == "__main__":
    tcp_echo_client()
