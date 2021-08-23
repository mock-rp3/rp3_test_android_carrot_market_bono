# 📌 API Sheet
> ### [Carrot Market API](https://docs.google.com/spreadsheets/d/1AN8mMcLtqntN6YwmVyS9J1ptAL1yD-AK/edit#gid=990061567)

<br />

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
- [ ] Open API로 도로명 주소 가져오기 >> 나중에 해보기
- [x] 회원가입 API 연동 _**( 08/16 )**_
- [x] 로그인 API 연동 >> 서버가 열리면 테스트 하기 >> _**( 08/17 )**_

# 📌 2주차 목표 작업 범위
> _2021/08/17 ~ 2021/08/24_     
> 개인 목표: 하루에 1.5개 완성하기 ( 17 😎 / 18 😎 / 19 😎 / 20 😭 / 21 😭 / 22 😎 / 23 )
- [x] 상품 디테일 화면 **_( 08/17 )_**
- [x] 나의 당근 페이지 _( 08/18 ) → **( 08/19 )**_
- [ ] 판매내역 _( 08/19 )_
- [ ] 상품 등록 _( 08/19 )_
- [ ] 카테고리  _( 08/20 )_
- [ ] 검색화면 _( 08/22 )_
- [ ] 앱 설정 _( 08/20 )_
- [x] 회원가입 화면 다시 구현하기 **_( 08/18 )_**
- [x] 자동 로그인
> API
- [x] 나의 당근 페이지 API  _**( 08/19 )**_
- [x] 새로 작성된 회원가입 API >> 서버가 열리면 테스트 하기 **_( 08/18 )_**
- [x] 새로 작성된 로그인 API **_( 08/19 )_**
- [x] 전체 게시글 조회 API >> 서버가 열리면 테스트 하기 **_( 08/21 )_**
- [ ] 상품 디테일 화면 API  _( 08/22 )_ >> Image를 vp2에 연결시키는 방법을 모르겠음 
- [ ] 판매글 작성 API
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

## 2021년 08월 17일 🌪🌧 [1차 피드백]
- 로그인 API 연동 **( 100% ✔ )** 지만 로그인 방식 변경으로 수정하기
- 스플래쉬 화면 **( 100% ✔)**
- 자동 로그인

> ### 📌 1차 피드백 
> - floating action button 메인 액티비티에 구현하기 ( 완료 ✔ )
>   - int로 나눠줘서 동네생활이랑 다르게 나오도록하고, 나머지 프래그먼트 눌렀을 때는 없애주기 ( 완료 ✔ )    
>     - 시도 해본적 없어서 난이도를 모르겠음. 다른 것들 우선 진행하고 시도해볼 예정 ( 아주 간단 )
> - 개발 우선순위의 7번 ~ 10번 사이로 구현해보기    
> - divider 코틀린 코딩 말고 item에 선 하나 그어줘도 됨.    
> - 처음 퍼블리싱 퀄리티를 잘 잡아두기 (나중에 해야지 하지말기 !!)


- 🚨 로그인 api를 사용하지 않고 회원가입 api를 사용자 api로 사용하기로 함. (회원가입과 로그인을 동시에 한다.)
```

[소셜 로그인 방식으로 진행]

 → 서버에서 문자 인증방식을 구현하기 어려워, id/pw/profileImage/nickname을 받아 회원가입 후 
   id/pw로 로그인하는 방식으로 상의 후 변경하였으나 (issue 2번 참고) 
   클라에서 기존 디자인을 변경해서 제작해야 하는 어려움이 발생함.
 
    →  로그인/회원가입에서 기존 디자인 방식 (번호 입력 후 인증번호를 받고 인증번호를 입력하면 로그인이 되는 방식)을 사용하되,
       번호는 id, 인증번호는 password로 구현하도록 함. (인증번호는 따로 발급받지 않는다.)
  
        →  서버에서는 구현 어려움을 줄이고, 클라에서는 디자인/퍼포먼스 퀄리티를 높일 수 있게됨 !
      
```
- 상품 디테일 화면 구현 **( 100% ✔)**
- 로그인화면 다시 구현하기
- **[Q]** 서버가 서버를 열여줘야만 작업할 수 있었던 issue가 있었으나, 
  - **[A]** 오늘이나 내일 aws서버로 옮기면 앞으로 서버가 계속 열려있을 거라고 말씀해주심!

## 2021년 08월 18일 🌞🌪
> Thread를 제외하고 삽질없이 착착 진행함 !
- **[Q]**  로그인/회원가입 클라 변경사항 서버에게 전달하고 서버 변경사항 전달받기
  - **[A]**  회원가입 시에는 번호를 아이디, 인증번호를 비밀번호로 받지만 로그인할 때는 일단 DB에 있는 번호라면 로그인되는 구조로 수정했다는 답변 받음 !
- 회원가입 화면 다시 구현하기 **( 100% ✔)** >> editText 디테일 신경쓰기
  - **[변경 구현]**  "인증문자 받기" >> "비밀번호 입력하기"
  - 코틀린에서 제공하는 Timer 사용
  - 글자 지우면 다시 원래 상태로 돌아가게 + 글자 수 충족 못하면 다음으로 못 넘어가게~
- 회원가입 API 다시 엮기  **( 100% ✔)**
- 상품 디테일 화면 디테일 신경쓰기 **( 100% ✔)**
- 나의 당근 페이지 구현하기 **( 70% ✔)**
- 나의 당근 페이지 API 엮기  **( 80% ✔)**
- **[Q]**  나의 당근 페이지 API에 해시태그 값이 없어서 서버에 여쭤봄
  - **[A]**  userInfoIdx(유저 인덱스값)로 생각하고 구현하셨다는 답변을 받음 ! 
  - 유일한 값이니 용도가 맞을 것 같아서 답변대로 진행하도록 함
- **[Q]**  나의 당근 페이지의 주소 값이 비어있어서 GPS 구현 후 추가 해주실건지 여쭤봄
  - **[A]**  주소 데이터는 의논이 필요한 문제로 서버에서 api를 엮을지 클라에서 api를 엮을지 정해보기로 함
  - 우선 텍스트뷰로 남겨놓고 천천히 진행하기로 함



## 2021년 08월 19일 🌞
> 자동 로그인과 나의 당근 페이지 API 엮기에서 삽질을 좀 많이했다. 성공조차 못했다 😥 >> SharedPreferences 이용해서 가볍게 성공했다. _( 8/20 )_
- 로그인 API 다시 엮기  **( 100% ✔)**
- 자동 로그인
- 나의 당근 페이지 API 엮기  **( 50% ✔)**
  - 어제 나의 당근 페이지 API 엮기는 성공했는데, 바로 화면에 표시되는게 안된다. >> path Variable 값을 임의로 입력해주면 성공하는데, 받아오는 방법은 아직 ! _(08/21)_
  - Glide 사용
- 나의 당근페이지 구현 **( 100% ✔)** >> API를 엮어야 하는데 잘 안돼유 >> 성공하긴 했는데 뭔가 부족함
  - 나의 당근 페이지에 있는 목록들을 ~~RecyclerView~~로 구현 해야할지 아니면 그냥 **Linear**로 해줘야할지 모르겠어서 고민 해보기
  - 카테고리 화면같은 경우 앱이 업데이트 돼서 수정이 발생할 경우를 가정해보면 **RecyclerView GridLayoutMananger** 혹은 **GridView** 로 구현하는 것이 적절하다.
  - 사진 받아올 때 oval 모양으로 받아오기 아직 안 함. _( 08/22 )_
- 판매내역 구현 **( 60% ✔)**
  - TabLayout + Viewpager2 연결 성공
- **[Q]** 나의 당근 페이지 같은 경우 로그인 후 나만 볼 수 있는 페이지인데 api 헤더 부분에 jwt같은 토큰이 없어서 내가 아닌 다른 유저들도 인덱스 번호만 입력하면 조회할 수 있다는 생각이 듦
  - **[A]** 서버에게 말씀드렸더니 그 부분을 잠깐 생각 못하셨다고 추가 해주시겠다고 답변을 주심
  - **[A+]** 추가적으로 [프로필 조회] 페이지는 유저 인덱스로만 조회할 수 있도록 해도 괜찮을 거 같아서 추후에 페이지 제작할 때는 이 방식으로 진행하도록 함.
- **[Q]** api를 계속 시도하고 싶은데 오류를 해결하느냐고 시간을 쓰게 됨. 알고보니 서버가 닫혀있어서 발생한 문제. 서버에 불편함을 말씀드림.
  - **[A]** aws로 진행하면 에러도 많이 나고 불안정하여 당분간은 이렇게 진행할 것 같다는 답변을 들음
    - **[Q]** 서버가 닫혀있으면 겪는 불편함을 다시 말씀 드리고 작업 시간대(PM 2:00 ~ AM 3:00) 사이에 서버를 장시간 닫을 경우 미리 알려주실 것을 요청함.
      - **[A]** 서버가 열리고 닫히는 것을 슬랙과 명세서에 알려주시기로 함 >> 자주자주 원활한 소통으로 문제없이 진행 중 👍🏻


## 2021년 08월 20일 🌞🌧
> 건강 Issue,,    

- 상품 등록 구현 **( 70% ✔)**
  - ~~Contextual menu~~, ~~popupMenu ?~~ , **Custom Dialog** ‼ >> 다이얼로그 리스트로 보여주기
- 카테고리 구현 (개발일지 2021년 08월 19일 참고)  **( 80% ✔)** >> 눌렀을 때 나오는 페이지는 홈 프래그먼트랑 비슷하지만 상단바 다름
- 앱 설정 구현  **( 100% ✔)**
- 자동 로그인 **( 100% ✔)**

## 2021년 08월 21일 🌞
> 꼭 해야하는 일: 이번 주까지 작업했던 것들 검토하며 디테일 더 많이 신경써보기 + 미러로이드 사이즈 고려하기
- 상품 등록 구현 **( 100% ✔)**
- 나의 당근 페이지 API path Variable 값 넘겨주기 // 나의 당근 페이지 API 완료 **( 100% ✔)**
- 전체 게시글 조회 API >> 서버 열리면 확인.. 
 
## 2021년 08월 22일 🌞
> 꼭 해야하는 일: 이번 주까지 작업했던 것들 검토하며 디테일 더 많이 신경써보기    
- **[Q]** 어제 하루종일 + 오늘 점심까지 서버가 닫혀있어서 api 작업을 못했다. api를 엮어둔 페이지는 서버가 닫히면 들어갈 수 없어서 이 상태로는 더이상 작업이 불가능할거 같아 다시 한번 요청 드림
    - **[A]** 어제는 열어놓고 나가신줄 알았다고 하셨다. 오늘도 열어놓으신줄 아셨다 한다..! 앞으로는 계속 서버 유지하실거라는 답변 받음 ! 

- 이미지들 둥근 모서리로 만들기
- 상품 디테일 화면 API  **( 90% ✔)**
    - 이미지는 하나씩 오는데, vp2에 이미지를 어떻게 넣어줘야될지 모르겠음
    - 유저 온도마다 temIcon 바꾸기
- 전체 게시글 조회 API  **( 100% ✔)**
  - **[Q]** ~ 초전, ~ 분전 타임스탬프로 계산된 상태인 데이터를 넘겨주실 수 있는지 여쭤봄 //클라에서도 처리할 수 있으나 서버가 데이터를 가지고 있는게 맞는거 같아서
    - **[A]** 작업 다 마치시고 시간되실 때 해주신다고 말씀해주심. 우선 생성된 날짜 넣어둠 //시간남으면 내가 해보기
  - price 값 int로 넘어오는거 3글자마다 쉼표 찍어주기
- 로딩 dialog 만들기
- 판매글 작성 API  **( 100% ✔)**

## 2021년 08월 23일 🌞

## 2021년 08월 24일 🌞 [2차 피드백]

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
```
   🚨 원래 방식으로 진행 하기로 다시 변경됨 ! (개발일지 2021년 08월 17일 참고)
```


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
        ... />
```
 ### 7. 서버 api URI 대소문자 구별하기 
  - **문제 🤦🏻‍♀ |** 로그인 api를 엮는 중에 포스트맨에서 "error": "Not Found" 가 발생했다.
  - **원인 💁🏻‍♀️ |** uri를 확인해보니 logIn(I 대문자)로 적으셨는데, 여태 login으로 post를 보내고 있었다.
  - **해결 🙆🏻‍♀️ |** 왜 에러가 발생했는지 api 문서를 되짚어 가며 해결 ! 
 
### 8. ScrollView can host only one direct child
  - **원인 💁🏻‍♀️ |** ScrollView 안에 자식은 하나만 존재해야 하는데 여러 개의 View가 있을 경우 발생
  - **해결 🙆🏻‍♀️ |** Layout으로 감싸주기

 ### 9. Switch 색상 바꾸기
  - **문제 🤦🏻‍♀ |** SwitchCompat을 on/off 해줬을 때 간단하게 thumbTint와 trackTint만 색상만 바뀌는데 커스텀 하기위해 drawable에 너무많은 xml을 추가해야 한다.
  - **해결 🙆🏻‍♀️ |** 애뮬레이터에서 직접 on/off를 해보니 on이 되었을 때 colorSecondary 색상으로 변하는 것을 알게되어 colorSecondary 색상을 변경 해주었다.
 

 ### 10. floating action button 프래그먼트마다 다르게 적용해주기
   - **해결 🙆🏻‍♀️ |**  int로 나눠줘서 동네생활이랑 다르게 나오도록하고 클릭 시 액티비티 이동, 나머지 프래그먼트 눌렀을 때는 없애주기 (대략적인 코드고 실제는 다르게 작성함)
```
   [Activity] MainActivity.kt

                private var fabState: Int = 1   
                         
                when (fabState) {
                    1 -> { binding.fabMain.visibility = View.VISIBLE }
                    2 -> { binding.fabMain.setImageResource(R.drawable.pencil_icon)
                        binding.fabMain.visibility = View.VISIBLE }
                                  
                                  ...
                       
                    5 -> { binding.fabMain.visibility = View.GONE }
                }
                
                                  ...
            binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->           
                when (item.itemId) {
                    R.id.menu_main_btm_nav_1_on -> {
                    fabState = 1
                                  ... 
                    }
                                  ... 
             }              
```
 - **문제 🤦🏻‍♀ |**  fabState 값은 바텀 네비게이션 아이콘을 클릭 한 후 변경되기 때문에 두 번 클릭해야 적용됐다. 그래서 그냥 바로 코드를 넣어주는 식으로 수정 구현하였다.



 ### 11. Error inflating class com.google.android.material.floatingactionbutton.FloatingActionButton
  - **문제 🤦🏻‍♀ |** 플로팅 액션 버튼이 자꾸 네모로 보이고, 실행도 안되고 바텀 네비게이션 바는 사라졌다. view 객체 생성에 문제가 생긴 것.
  - **해결 🙆🏻‍♀️ |** [다음과 같은 문제](https://jootc.com/p/201908013017)가 발생한 것이었고, themes을 수정해주니 괜찮아졌다.
 ```
  [res/themes.xml]
         <item name="colorPrimary">@null</item>
        <item name="colorPrimaryVariant">@null</item>
                           ⬇
         <item name="colorPrimary">@color/mainColor</item>
        <item name="colorPrimaryVariant">@color/mainColor</item>
 
 ```


 ### 12. 카테고리 메뉴
  - **문제 🤦🏻‍♀ |** 이런 메뉴는 어떤 걸 사용해서 만들까 하면서 검색해보다가 [이 사이트](https://dinfree.com/lecture/android/android_2.4.html)를 보았는데 Context Menu가 내가 찾던 메뉴 여서 만들어 보았다. 근데 Context Menu는 롱클릭을 해야지 메뉴가 생기고 내가 원하는 모습이 아니었다. 그래서 Popup Menu로 만들어 보았다. 클릭하면 나오긴 하는데 내가 원하는 위치에는 안 나온다. 공식문서를 보니 gravity 값을 조정할 수 있다하는데, 생각한 모습과 전혀 다른 모습이었다.
  - **해결 🙆🏻‍♀️ |** 다이얼로그를 리스트로 보여주는 방식을 사용하면 됐다 ..
```
   [Activity] ProductWriteActivity.kt
   
       fun showDialog() {
        val write_cate = resources.getStringArray(R.array.write_cate)

        val builder = AlertDialog.Builder(this)
        builder.setItems(write_cate, DialogInterface.OnClickListener { dialog, which ->
            binding.productWriteTxtCate.text = write_cate[which].toString()
        }
        )
        var alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
```

 ### 13. 헤더에 토큰 넣어주기
  - **문제 🤦🏻‍♀ |**  헤더에 토큰 넣어주는게 간단한거 같은데 자꾸 jwt 값이 없다해서 스트레스 받았다.
  - **해결 🙆🏻‍♀️ |**  로그를 찍어보며 원인을 찾았다. 정말 간단하고 시간 투자할 일이 아닌데 멀리 돌아간 것 같다. 다신 같은 삽질을 하지 않아야 겠다!
  ```
       [Data class] RequestMyPage.kt
  
            data class RequestMyPage (
            @SerializedName("userInfoIdx") val userInfoIdx: Int,
            @Header("x-access-token") val X_ACCESS_TOKEN:String
            )
    
       [Service] MyPageService.kt
    
           fun tryGetMyPage(X_ACCESS_TOKEN:String ,userInfoIdx: Int){
           val myPageRetrofitInterface =
                ApplicationClass.sRetrofit.create(UsersRetrofitInterface::class.java)
           myPageRetrofitInterface.getMyPage(X_ACCESS_TOKEN,userInfoIdx).enqueue(object:
                          ...
            
       [Fragment] MyPageFragment.kt
           
           sSharedPreferences =
              requireActivity().getSharedPreferences(X_ACCESS_TOKEN, AppCompatActivity.MODE_PRIVATE)
           val jwt = sSharedPreferences.getString(X_ACCESS_TOKEN, null)!!
                   Log.e("jwt10", jwt.toString()) // 값이 잘 넘어오는지 로그 찍어보기 📌

          sSharedPreferences =
              requireActivity().getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

          val userIdx = sSharedPreferences.getInt("userIdx", 0)
          Log.e("userIdx2", userIdx.toString()) // 값이 잘 넘어오는지 로그 찍어보기 📌
          MyPageService(this).tryGetMyPage(jwt, userIdx)
  ```
### 14. 3글자 마다 쉼표찍기
  - **해결 🙆🏻‍♀️ |** DecimalFormat 사용하기
  ```
   [adapter] HomeAdapter.kt
          val decimalFormat = DecimalFormat("###,###")
        val priceDecimalFormat =decimalFormat.format(productDataList[position].price)
        holder.binding.homeItemPrice.text = "$priceDecimalFormat 원"
  ```
### 15. java.net.UnknownServiceException: CLEARTEXT communication to prod.carrotmarket2.shop not permitted by network security policy 
 - **문제 🤦🏻‍♀ |** 서버 url이 https가 아닌 http로 되어있어서 생긴 문제
 - **해결 🙆🏻‍♀️ |**
   ```
   [Manifest]
   android:usesCleartextTraffic="true"
     ```
   
   
   
 <br />
 
# 📌 참고자료
- [Fragment Context](https://hanyeop.tistory.com/239)
- [Floating action button Animation](https://greimul.tistory.com/29)
- [CardView Z 속성](https://developer.android.com/guide/topics/ui/look-and-feel)
- [Viewpager2 Indicator custom](https://android-dev.tistory.com/12)
- [Timer](https://magicalcode.tistory.com/49)
- [TabLayout+Viewpager2](https://sys09270883.github.io/app/44/)
- [Retrofit-Header](https://hyongdoc.tistory.com/186)
- [안드로이드에서 JWT 사용하기 이해하기 좋은 블로그](https://hyogeun-android.tistory.com/entry/12-Retrofit-%EC%84%9C%EB%B9%84%EC%8A%A4%EC%99%80-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B7%B8%EB%A6%AC%EA%B3%A0-SharedPref)
- [로그인](https://hyogeun-android.tistory.com/entry/12-Retrofit-%EC%84%9C%EB%B9%84%EC%8A%A4%EC%99%80-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B7%B8%EB%A6%AC%EA%B3%A0-SharedPref)
- [ScrollView can host only one direct child](https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=credenda&logNo=80152077567)
- [PopupMenu](https://developer.android.com/reference/android/support/v7/widget/PopupMenu.html) (x)
- [Context Menu](https://lktprogrammer.tistory.com/162) (x) >> 길게 눌렀을 때 나오는 메뉴 
- [다이얼로그 리스트로 보여주는 방법](https://aries574.tistory.com/109) (o)
