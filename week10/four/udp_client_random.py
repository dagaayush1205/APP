import socket
import random

def udp_client():
    # Define server address and port
    server_address = ('localhost', 65434)

    # Create a UDP socket
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as client_socket:
        # Generate a random number to send
        number = random.randint(1, 100)
        print(f"Sending random number to server: {number}")

        # Send the number to the server
        client_socket.sendto(str(number).encode(), server_address)

        # Receive even/odd result from the server
        response, _ = client_socket.recvfrom(1024)
        print("Received from server:", response.decode())

# Run the client
if __name__ == "__main__":
    udp_client()

