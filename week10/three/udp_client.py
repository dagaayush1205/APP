import socket

def udp_client():
    # Define server address and port
    server_address = ('localhost', 65433)
    
    # Create a UDP socket
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as client_socket:
        # Send a message to the server
        message = "UDP Message"
        client_socket.sendto(message.encode(), server_address)
        print("Message sent to server:", message)

        # Receive acknowledgment from the server
        response, server = client_socket.recvfrom(1024)
        print("Acknowledgment received from server:", response.decode())

# Run the client
if __name__ == "__main__":
    udp_client()

