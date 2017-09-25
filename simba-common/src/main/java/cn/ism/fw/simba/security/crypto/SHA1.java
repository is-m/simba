/**
 *
 * Copyright © 2014 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package cn.ism.fw.simba.security.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import cn.ism.fw.simba.util.StringUtil;

public class SHA1 {

    /**
     * Used by the hash method.
     */
    private static MessageDigest SHA1_DIGEST;

    static {
        try {
            SHA1_DIGEST = MessageDigest.getInstance(StringUtil.SHA1);
        }
        catch (NoSuchAlgorithmException e) {
            // Smack wont be able to function normally if this exception is thrown, wrap it into
            // an ISE and make the user aware of the problem.
            throw new IllegalStateException(e);
        }
    }

    public static synchronized byte[] bytes(byte[] bytes) {
        SHA1_DIGEST.update(bytes);
        return SHA1_DIGEST.digest();
    }

    public static byte[] bytes(String string) {
        return bytes(StringUtil.toBytes(string));
    }

    public static String hex(byte[] bytes) {
        return StringUtil.encodeHex(bytes(bytes));
    }

    public static String hex(String string) {
        return hex(StringUtil.toBytes(string));
    }

}