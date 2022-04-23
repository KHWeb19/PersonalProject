<template>
  <body>
    <footer class="global-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <h3 class="global-footer-title">
              고객센터
              <i class="ic-chevron" aria-hidden></i>
            </h3>
            <a class="global-footer-contact" href="tel:4646-4646">4646-4646</a>
            <p class="global-footer-time">
              평일 09:00 ~ 18:00 (주말 &amp; 공휴일 제외)
            </p>

            <dl class="global-footer-detail-list">
              <div class="global-footer-detail-item">
                <dt>상호명</dt>
                <dd>(주)토피아</dd>
              </div>
              <div class="global-footer-detail-item">
                <dt>이메일</dt>
                <dd>
                  <address>
                    <a href="mailto:bean326@naver.com">bean326@naver.com</a>
                  </address>
                  (제휴문의)
                </dd>
              </div>
              <div class="global-footer-detail-item">
                <dt>대표이사</dt>
                <dd>박성빈</dd>
              </div>
              <div class="global-footer-detail-item">
                <dt>사업자등록번호</dt>
                <dd>119-82-535353</dd>
              </div>
              <div class="global-footer-detail-item">
                <dt>본사주소</dt>
                <dd>서울특별시 강남구 어딘가 111, 408호</dd>
              </div>
              <div class="global-footer-detail-item">
                <dt>반품주소</dt>
                <dd>경기도 안성시 원곡면 성은리 어딘가</dd>
              </div>
            </dl>
          </div>
        </div>
      </div>
    </footer>
  </body>
</template>
<script>
export default {
  name: "Footer-Layout",
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/footer";
</style>
