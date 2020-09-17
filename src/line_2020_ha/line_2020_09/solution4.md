### **문제 설명**

미로를 탈출하는 방법 중에 왼손법칙이라는 것이 있습니다. 이 방법은 미로의 벽에 왼쪽 손을 대고 계속 걷는 방법입니다. 왼손법칙을 이용했을 때, 미로를 탈출하는 데 걸리는 시간을 구하려고 합니다.

1 x 1 크기 정사각 칸으로 이루어진 N x N 크기의 미로가 주어집니다. 미로를 탈출하는 사람은 0행 0열에서 시작하며, `N-1`행 `N-1`열에 도착하면 탈출에 성공합니다. 1초에 상하좌우 한 칸씩 이동할 수 있으며, 대각선으로 이동할 수 없습니다.

아래 그림은 미로를 탈출하려는 사람의 초기 위치와 미로의 구조를 나타냅니다. 0과 1은 각각 비어있는 공간과 벽을 나타냅니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/63632ffa-33c9-47b6-b942-3f4d0b5f934b/example0_start0.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/63632ffa-33c9-47b6-b942-3f4d0b5f934b/example0_start0.png)

0행 0열부터 왼손을 벽에 대고 걷게 되면 아래 그림에 표시된 화살표를 따라 미로를 순회합니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/560138bc-4d38-41da-bc01-1faecae5eb89/example0_start0_arrow.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/560138bc-4d38-41da-bc01-1faecae5eb89/example0_start0_arrow.png)

위 그림과 같이 미로를 순회하게 되면 총 10회의 칸 이동을 하게 됩니다. 즉, 미로를 탈출하는 데 10초가 걸립니다.

미로를 나타내는 2차원 배열 maze가 매개변수로 주어집니다. 왼손법칙을 이용해 미로를 탈출할 때 걸리는 시간을 return 하도록 solution 함수를 완성해주세요.

------

### 제한사항

- maze는 2차원 정사각 배열로, 길이는 3 이상 300 이하입니다.
- maze의 각 원소의 값은 0 또는 1입니다.
  - 배열의 가장 왼쪽 상단과 가장 오른쪽 하단은 각각 시작 지점과 종료 지점으로, 항상 0입니다.
  - 원소의 값 0은 칸이 비어 있어 이동이 가능함을, 1은 벽으로 채워져 있어 이동이 불가능함을 나타냅니다.
- maze는 항상 왼손법칙을 이용해 탈출할 수 있는 형태로 주어집니다.

------

### 입출력 예



------

### 입출력 예 설명

입출력 예 #1문제 예시와 같습니다.

입출력 예 #2

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/d86bc3e4-1c60-4a23-963e-4fdc3eb780e1/example1_start0.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/d86bc3e4-1c60-4a23-963e-4fdc3eb780e1/example1_start0.png)

위와 같이 이동하면 32초가 걸립니다.

입출력 예 #3

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/07177970-f7a2-4ff9-9ed0-1b43b0c688e3/example2_start0.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/07177970-f7a2-4ff9-9ed0-1b43b0c688e3/example2_start0.png)

위와 같이 이동하면 24초가 걸립니다.

입출력 예 #4

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/60d5f8eb-30c1-4571-aa40-8cdd7bec3e7f/example3_start0.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/60d5f8eb-30c1-4571-aa40-8cdd7bec3e7f/example3_start0.png)

0행 1열에 벽이 없는 경우, 0행 0열 칸의 위쪽 벽에 왼손을 대고 열이 증가하는 방향으로 이동합니다. 위와 같이 이동하면 22초가 걸립니다.