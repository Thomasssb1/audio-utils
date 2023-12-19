import 'package:jni/jni.dart';
import 'package:jni/src/jarray.dart';

import 'package:jni/src/lang/jstring.dart';

import '../lib/audio_utils/com/thomasb/audio_utils/Command.dart';

void main() {
  JArray<JString> args = JArray<JString>(JString.type, 2);
  args[0] = JString.fromString("--input");
  args[1] = JString.fromString("test.mp3");
  Command.setArgs(args);
  var options = Command.parseArgs();
  Command.storeParsedArgs(options);
  print(options);
  options.release();
}
