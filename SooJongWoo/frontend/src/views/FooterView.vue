<template>
  <v-footer padless>
    <v-card flat width="100vw" title class="grey lighten-3 text-center">
      <div class="justify center">
        <v-card-text class="pt-0">
          <p style="margin-top: 1%">
            <b>이용약관</b><b style="padding-left: 1%">개인정보처리방침</b
            ><b style="padding-left: 1%">비즈니스</b
            ><b style="padding-left: 1%">위치기반서비스이용약관</b
            ><b style="padding-left: 1%">고객센터</b>
          </p>
          <p style="margin-bottom: 3px">
            <b>HOTEL</b> HAWUL
            <b style="padding-left: 1%"> ADDRESS</b> 주소적는칸
            <b style="padding-left: 1%"> TEL</b> 012-345-6789 (대표: HAWUL)
          </p>
        </v-card-text>
      </div>

      <v-divider></v-divider>
      <v-card-text>
        {{ new Date().getFullYear() }} -
        <strong>COPYRIGHT(C) HAWUL HOTEL. ALL RIGHTS RESERVED.</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>