# 📌 1주차 목표 작업 범위
> _2021/08/14 ~ 2021/08/17_ 
- [x] 로그인 화면 _( 08/14 )  → **( 08/16 )**_
- [x] 회원가입 화면 _( 08/14 ) → **( 08/16 )**_
- [x] 홈 화면 _( 08/15 ) → **( 08/16 )**_
- [x] 스플래쉬 화면 _**( 08/17 )**_
- [x] 뼈대 레이아웃 구성(네비게이션 탭 등) _( 08/14 ) → **( 08/16 )**_
- [ ] 이미지 리소스 구하기 
- [ ] 자동 로그인 구현 >> 로그인이랑 회원가입 분리 후 시도해보기
> API
- [ ] Open API로 도로명 주소 가져오기
- [x] 회원가입 API 연동 _**( 08/16 )**_
- [ ] 로그인 API 연동 >> 서버가 열리면 테스트 하기

# 📌 2주차 목표 작업 범위
> _2021/08/17 ~ 2021/08/24_ 
- [ ] 상품 디테일 화면
- [ ] 나의 당근 페이지
- [ ] 판매내역
- [ ] 상품 등록
- [ ] 카테고리
- [ ] 검색화면
- [ ] 앱 설정

<br />

# 📌 개발일지
> _2021/08/14 ~ 2021/08/27_ 까지의 과정을 담은 개발일지 
## 2021년 08월 14일 🌞
- 개발환경 구축 ( 70% ✔)
  - Sourcetree 사용에 어려움이 있어 **GitHub Desktop** 으로 변경하여 진행하도록 함.
- 뼈대 레이아웃 구성 ( 50 % ✔)

## 2021년 08월 15일 🌞💧
- 개발환경 구축 ( 100% ✔)
- 로그인 화면 구현 ( 90% ✔)
- 이미지 리소스 구하기

## 2021년 08월 16일 🌞
- 로그인 화면 구현 **( 100% ✔)**
- 회원가입 화면 구현 **( 100% ✔)**
- **회원가입 API 엮기 ( 90% ✔)**
- 로그인 API 엮기
- 홈 화면 **( 100% ✔)**
- 스플래쉬 화면 **( 100% ✔)**
- 뼈대 레이아웃 디테일 구성 **( 100% ✔)**
- 이미지 리소스 구하기

## 2021년 08월 17일 🌪 [📌 1차 피드백]
- 로그인 API 연동 >> 서버가 열리면 테스트 하기
- 스플래쉬 화면 **( 100% ✔)**
- 자동 로그인

> ### 📌 1차 피드백 
> - floating action button 메인 액티비티에 구현하기 (int로 나눠줘서 동네생활이랑 다르게 나오도록하고, 나머지 프래그먼트 눌렀을 때는 없애주기)     
> - 개발 우선순위의 7번 ~ 10번 사이로 구현해보기    
> - divider 코틀린 코딩 말고 item에 선 하나 그어줘도 됨.    

#### [피드백 이후]
- 

<br />

# 📌 _Issue_
> 프로젝트를 진행하면서 발생한 문제와 해결 방안       
### 1. 안드로이드와 아이폰의 차이
  - **문제 🤦🏻‍♀ |** 아이폰과 안드로이드의 디자인이 달라 레이아웃 구성에 어려움을 겪음.
  - **해결 🙆🏻‍♀️ |** 안드로이드 공기계를 이용하기로 함 !

### 2. 회원가입 시 실제 받아오는 데이터와 서버 api에서 제공해주는 데이터 차이
  - **문제 🤦🏻‍♀ |** 실제 당근마켓 회원가입에서는 번호만 입력받아 회원가입/로그인을 진행하지만, 협업을 진행하는 서버 측에서 제공해주는 api에서는 아이디/패스워드/프로필 사진을 제공해준다. 레이아웃 구성 시 기존 번호만 받는 레이아웃으로 그대로 진행해야 할지 아니면 서버 api에서 주는 정보대로 구성해야 할지 어려움을 겪음.
  - **원인 💁🏻‍♀️ |** 서버 측 개발팀장님께서 번호 문자 인증이 어려워 일단 아이디/패스워드를 받아 jwt로 로그인하는 방식으로 구현하라고 말씀하셨음. 
  - **해결 🙆🏻‍♀️ |** 서버 개발자 + 서버측 개발팀장님의 의견에 따라 아이디/패스워드을 받아오는 레이아웃으로 재구성 함 !

### 3. API 엮는거에 대한 이해도 부족
  - **문제 🤦🏻‍♀ |** 회원가입 API에 바디 값이 4개 (id/pw/profileImage/nickname)인데, A 액티비티에서 id/pw 값을 받고 B 넘어간 후, B 액티비티에서 profileImage/nickname을 입력받고 싶은데 방법을 찾는데 어려움을 겪음.
  - **뻘짓 🙅🏻‍♀️ |**  A 액티비티에서 id/pw 값을 받고 profileImage/nickname 값을 임의로 입력하여 다음으로 넘어가면 저장된 id/pw 값을 불러오고 다시 요청을 보낸다. >> 요청이 2번 발생함 (X)
  - **원인 💁🏻‍♀️ |**  너무 어렵게 생각했던 것 같다 !
  - **해결 🙆🏻‍♀️ |**  A 액티비티에서 intent로 id/pw값을 넘겨주고 B 액티비티에서 최종 회원가입을 성공시킨다. >> 서버 측에서 적어준 vaildation 처리는 어떻게 되는건지 싶었지만 클라에서도 회원가입이 안되는 로직이 만들어 적용해야 되기 때문에 상관없을 것 같다.

### 4. Fragment에서 RecyclerView 사용하기
  - **문제 🤦🏻‍♀ |**  Activity(RecyclerView)와 Adapter를 연결해줄 때, LoginLocationActivity.kt에서 작성했던 것처럼 this를 context에 넘겨주는데, Fragment에서도 동일하게 코드를 작성해주었더니 thist에 빨간 줄이 발생하였다.
   ``` 
  [Activity] LoginLocationActivity.kt
   
        loginLocationAdapter = LoginLocationAdapter(this, locationArrayList)
        binding.loginLocationRvAround.adapter = loginLocationAdapter
   ```
  - **뻘짓 🙅🏻‍♀️ |**  [1] this를 어떻게든 사용하기 위해 @를 사용해보았다.   [2] 자바에서 처럼 getActivity를 사용해보았다.    [3] Activity()를 사용해보았다.
  - **원인 💁🏻‍♀️ |**  이 부분을 Activity에 작성할 경우 getActivity()를 this로 작성할 수 있는데, 이 클래스는 Fragment를 상속받으므로 해당 Fragment를 관리하는 Activity를 리턴하는 함수(getActivity())를 매개변수로 넘겨야 한다. 
  - **해결 🙆🏻‍♀️ |** 코틀린의 경우 Activity를 를 이용하여 부모 액티비티의 context 값을 가져와 사용할 수 있다. null 값의 예외처리를 보장하려면 requireActivity() 를 사용해야하므로, **requireActivity()** 사용이 권장된다고 한다. (requireContext()도 해봤는데 됐다!)  //DividerItemDecoration에서 this 값에도 사용하였다. 
   ```
   [Fragment] HomeFragment.kt
   
        homeAdapter = HomeAdapter(requireActivity(), productArrayList)
        binding.homeRv.adapter = homeAdapter
   ```
### 5. Floating Action Button Icon Color
  - **문제 🤦🏻‍♀ |** Floating Action Button의 Icon Color가 변경되지 않고 검정색으로 적용되있다.
  - **원인 💁🏻‍♀️ |** 자동완성에서도 android로 해주는데 왜 이러는지 모르겠음 //v23 이후 설계 지원 라이브러리의 경우 app 이라고 한다.
  - **뻘짓 🙅🏻‍♀️ |**  [1] android:Tint (x)
  - **해결 🙆🏻‍♀️ |** app:Tint="@color/white"로 해결 !


### 6. View 위치와 카드뷰 elevation의 관계 !
  - **문제 🤦🏻‍♀ |** Floating Action Button를 누르면 배경이 투명한 검정색이 되도록 하고 싶어서 View를 넣어줬는데, 전체를 덮는게 아니라 이미지나 탑바의 border 같은 거랑 특히 카드뷰가 View보다 앞에 나와있다. bringToFront()을 해주면 가장 앞으로 나온다길래 해주었는데, 카드뷰는 안 덮였다.
  - **원인 💁🏻‍♀️ |** Android의 뷰에는 X 및 Y 속성 외에도 Z 속성이 있다. Z 값이 더 높은 뷰가 다른 뷰 위에 표시된다고 한다.
  - **해결 🙆🏻‍♀️ |** 검색해도 모르겠어서 혹시나하고 카드뷰의 elevation 값을 조정 해보았더니..  
```
   <androidx.cardview.widget.CardView
        ...
      app:cardElevation="0dp"
        ...
   />
```
   
 <br />
 
# 📌 참고자료
- [Fragment Context](https://hanyeop.tistory.com/239)
- [Floating action button Animation](https://greimul.tistory.com/29)
- [CardView Z 속성](https://developer.android.com/guide/topics/ui/look-and-feel)
