import socket

def udp_server():
    # Define host and port
    host = 'localhost'
    port = 65433

    # Create a UDP socket
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server_socket:
        # Bind the socket to address and port
        server_socket.bind((host, port))
        print("UDP server is listening on port", port)

        # Receive a message from the client
        data, client_address = server_socket.recvfrom(1024)
        print("Received from client:", data.decode())

        # Send an acknowledgment back to the client
        response = "Message received"
        server_socket.sendto(response.encode(), client_address)
        print("Acknowledgment sent to client.")

# Run the server
if __name__ == "__main__":
    udp_server()

