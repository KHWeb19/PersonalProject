import Vue from 'vue'
import { extend, ValidationObserver, ValidationProvider } from "vee-validate";
import { max, required, numeric, digits, email, confirmed, alpha_num} from "vee-validate/dist/rules";

extend("max", {
  ...max,
  message: `{_field_}는 {length}자를 초과할 수 없습니다.`,
});
extend("required", {
  ...required,
  message: `{_field_}는 필수값 입니다.`,
});
extend("numeric", {
  ...numeric,
  message: `{_field_}는 숫자로만 구성되어야합니다.`,
});
extend("digits", {
  ...digits,
  message: `{_field_}는 {length}자리여야합니다.`,
});
extend("email", {
  ...email,
  message: `잘못 입력된 이메일 주소입니다.`,
});
extend('confirmed', {
  ...confirmed,
  message: '비밀번호와 일치하지 않습니다.'
})
extend('alpha_num', {
  ...alpha_num,
  message: '영문자, 숫자로만 구성되어야합니다.'
})
Vue.component('ValidationObserver',ValidationObserver)
Vue.component('ValidationProvider',ValidationProvider)