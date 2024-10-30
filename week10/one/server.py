
import socket

def tcp_server():
    # Define host and port
    host = 'localhost'
    port = 65432  # Use the same port as the client

    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        # Bind the socket to address and port
        server_socket.bind((host, port))
        server_socket.listen()
        print("Server is listening on port", port)

        # Accept a connection from the client
        conn, addr = server_socket.accept()
        with conn:
            print("Connected by", addr)

            # Receive data from the client
            data = conn.recv(1024).decode()
            print("Received from client:", data)

            # Send a response back to the client
            response = "Hello, Client!"
            conn.sendall(response.encode())
            print("Response sent to client.")

# Run the server
if __name__ == "__main__":
    tcp_server()
