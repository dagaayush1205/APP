
import socket
import json

def tcp_server():
    # Define host and port
    host = 'localhost'
    port = 65432

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

            # Receive list of numbers from the client
            data = conn.recv(1024).decode()
            numbers = json.loads(data)  # Decode JSON to get the list
            print("Received list of numbers from client:", numbers)

            # Calculate the sum of the numbers
            total_sum = sum(numbers)

            # Send the sum back to the client
            conn.sendall(str(total_sum).encode())
            print("Sum sent to client:", total_sum)

# Run the server
if __name__ == "__main__":
    tcp_server()
