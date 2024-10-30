
import socket

def udp_server():
    # Define host and port
    host = 'localhost'
    port = 65434

    # Create a UDP socket
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server_socket:
        # Bind the socket to address and port
        server_socket.bind((host, port))
        print("UDP server is listening on port", port)

        while True:
            # Receive data from the client
            data, client_address = server_socket.recvfrom(1024)
            number = int(data.decode())
            print(f"Received from client: {number}")

            # Check if the number is even or odd
            if number % 2 == 0:
                result = "Even"
            else:
                result = "Odd"
            print(f"Sending result to client: {result}")

            # Send result back to the client
            server_socket.sendto(result.encode(), client_address)

# Run the server
if __name__ == "__main__":
    udp_server()
