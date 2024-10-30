import socket

def udp_server():
    # Define host and port
    host = 'localhost'
    port = 54321

    # Create a UDP socket
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server_socket:
        # Bind the socket to the specified port
        server_socket.bind((host, port))
        print("UDP server is listening on port", port)

        while True:
            # Receive data from any client
            data, client_address = server_socket.recvfrom(1024)
            print(f"Received '{data.decode()}' from {client_address}")

            # Optionally, send an acknowledgment back to the client
            response = "Message received"
            server_socket.sendto(response.encode(), client_address)

# Run the server
if __name__ == "__main__":
    udp_server()

