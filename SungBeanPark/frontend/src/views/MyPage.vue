<template>
  <body>
    <header-layout></header-layout>
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <div class="myhome-edit">
            <div class="myhome-edit-header">
              <div class="myhome-edit-header title">회원정보수정</div>
              <a class="myhome-edit-header link" href="">탈퇴하기</a>
            </div>
            <form class="myhome-edit-form">
              <div class="myhome-edit-item">
                <div class="myhome-edit-item title">
                  이메일
                  <div class="myhome-edit-item title-require">* 필수항목</div>
                </div>
                <div class="myhome-edit-inputgroup">
                  <span class="myhome-edit-inputgroup-email">
                    <input
                      class="myhome-edit-item title-input"
                      type="text"
                      placeholder="이메일"
                      value
                    />
                  </span>
                  <span>@</span>
                  <span class="myhome-edit-inputgroup-email">
                    <input
                      class="myhome-edit-input"
                      type="text"
                      placeholder="입력해주세요"
                      value=""
                    />
                  </span>
                </div>
              </div>
              <div class="myhome-edit-item">
                <div class="myhome-edit-item title">
                  별명
                  <div class="myhome-edit-item title-require">* 필수항목</div>
                </div>
                <div class="myhome-edit-inputgroup">
                  <span>
                    <input
                      class="myhome-edit-item input"
                      type="text"
                      placeholder="별명"
                      value
                    />
                  </span>
                </div>
              </div>
              <div class="myhome-edit-item">
                <div class="myhome-edit-item title">비밀번호</div>
                <div class="myhome-edit-inputgroup">
                  <span>
                    <input
                      class="myhome-edit-item input"
                      type="password"
                      placeholder="비밀번호"
                      value
                    />
                  </span>
                </div>
              </div>
              <div class="myhome-edit-item">
                <div class="myhome-edit-item title">비밀번호 확인</div>
                <div class="myhome-edit-inputgroup">
                  <span>
                    <input
                      class="myhome-edit-item input"
                      type="password"
                      placeholder="비밀번호 확인"
                      value
                    />
                  </span>
                </div>
              </div>
              <div class="myhome-edit-item">
                <div class="myhome-edit-item title">성별</div>
                <div>
                  <ul class="radio-group-input">
                    <li>
                      <div class="form-radio">
                        <label class="form-radio-label" for="">
                          <input type="radio" />
                          <span>남성</span>
                        </label>
                      </div>
                    </li>
                    <li>
                      <div class="form-radio">
                        <label class="form-radio-label" for="">
                          <input type="radio" />
                          <span>여성</span>
                        </label>
                      </div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="myhome-edit-item">
                <div class="myhome-edit-item title">생년월일</div>
                <div class="myhome-edit-inputgroup">
                  <span>
                    <input
                      class="myhome-edit-item input"
                      type="text"
                      placeholder="YYYY-MM-DD"
                      value
                    />
                  </span>
                </div>
              </div>
              <div class="myhome-edit-item">
                <div class="myhome-edit-item title">주소</div>
                <div class="myhome-edit-inputgroup">
                  <span>
                    <input
                      class="myhome-edit-item input"
                      type="text"
                      placeholder="주소"
                      value
                    />
                  </span>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <footer-layout></footer-layout>
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
export default {
  name: "MyPage",

  components: {
    HeaderLayout,
    FooterLayout,
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/myhome";
</style>
