import socket

def tcp_file_server():
    # Define host and port
    host = 'localhost'
    port = 65438

    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        # Bind the socket to address and port
        server_socket.bind((host, port))
        server_socket.listen()
        print("File server is listening on port", port)

        # Accept a connection from the client
        conn, addr = server_socket.accept()
        with conn:
            print("Connected by", addr)

            # Receive the file data from the client
            file_data = b""
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                file_data += data

            # Save the received data to a file
            with open("received_sample.txt", "wb") as file:
                file.write(file_data)
            print("File received and saved as 'received_sample.txt'")

# Run the server
if __name__ == "__main__":
    tcp_file_server()

