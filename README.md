# Memo App by `Kotlin`
- RecyclerView
- RoomDB
- SharedPrefernece


## 기능명세
- RecyclerView를 활용한 메모장 앱 만들기
    - 메인 화면
       - 메모 목록을 표시하는 RecyclerView와 메모 추가 Button으로 구성
       - RecyclerView의 각 Item에는 메모의 내용이 보이도록 TextView 설정
       - 각 Item을 누르면 Item이 삭제되도록 구성
       - 메모 추가 Button을 누르면 데이터를 받을 수 있도록 설정하고 글쓰기 화면으로 넘어가기
       - 돌아오면 넘어온 데이터를 가지고 RecyclerView에 추가
  - 메모 화면
       - 메모를 할 수 있는 EditText와 저장 Button으로 구성
       - EditText는 여러 줄을 입력할 수 있도록 설정
       - 저장 Button을 누르면 메인 화면으로 넘길 데이터를 설정하고 메모 화면 닫기
- RoomDB를 이용하여 메모장 앱의 메모들이 앱이 껐다 켜져도 유지 (저장)되도록 하기
- SharedPreference를 이용하여 메모 즐겨찾기 기능 구현하기
  - 각각의 메모에 즐겨찾기 버튼 만들기(누르면 보관함에서 그 메모를 확인 가능)
  - 보관함 Activity는 새로 생성하기
- RoomDB를 이용해서 메모 좋아요 기능 구현하기
  - 각각의 메모에 좋아요 토글 (ON/OFF) 버튼 만들기
  - 좋아요 여부에 따라서 토글 버튼의 ON/OFF 설정하기
