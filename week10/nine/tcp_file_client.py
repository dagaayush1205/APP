import socket

def tcp_file_client():
    # Define server address and port
    server_address = ('localhost', 65438)

    # File to be sent
    file_path = 'sample.txt'

    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        # Connect to the server
        client_socket.connect(server_address)
        print("Connected to file server.")

        # Open the file and read its content
        with open(file_path, 'rb') as file:
            data = file.read()
            # Send file data to the server
            client_socket.sendall(data)
            print("File sent to server:", file_path)

# Run the client
if __name__ == "__main__":
    tcp_file_client()

