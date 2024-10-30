import socket

def tcp_echo_server():
    # Define host and port
    host = 'localhost'
    port = 65437

    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        # Bind the socket to address and port
        server_socket.bind((host, port))
        server_socket.listen()
        print("Echo server is listening on port", port)

        # Accept a connection from the client
        conn, addr = server_socket.accept()
        with conn:
            print("Connected by", addr)
            while True:
                # Receive data from the client
                data = conn.recv(1024)
                if not data:
                    break
                print("Received from client:", data.decode())

                # Echo back the received message
                conn.sendall(data)

# Run the server
if __name__ == "__main__":
    tcp_echo_server()

