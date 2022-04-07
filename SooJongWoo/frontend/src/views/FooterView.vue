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
        </v-card-text>
      </div>

      <v-divider></v-divider>
      <v-card-text>
        {{ new Date().getFullYear() }} - <strong>COPYRIGHT(C)</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data() {
    return {
      icons: ["home", "phone_in_talk", "event_available"],
    };
  },
};
</script>